package ru.itis.school_api.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.school_api.dto.authentication.SignInForm;
import ru.itis.school_api.exception.ValidationException;
import ru.itis.school_api.model.Student;
import ru.itis.school_api.security.details.StudentAccountDetails;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Slf4j
public class JwtTokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper;
    private final String secretKey;
    private final Validator validator;

    public JwtTokenAuthenticationFilter(AuthenticationManager manager, ObjectMapper objectMapper, String secretKey, Validator validator) {
        super(manager);
        this.objectMapper = objectMapper;
        this.secretKey = secretKey;
        this.validator = validator;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            SignInForm signInForm = objectMapper.readValue(request.getReader(), SignInForm.class);

            Set<ConstraintViolation<SignInForm>> violations = validator.validate(signInForm);
            if(!violations.isEmpty()) {
                throw new ValidationException(violations.stream().findFirst().get().getMessage());
            }

            log.info("Attempt authentication - email {}", signInForm.getEmail());

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword());

            return super.getAuthenticationManager().authenticate(token);

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        StudentAccountDetails userDetails = (StudentAccountDetails) authResult.getPrincipal();
        Student account = userDetails.getAccount();

        String token = JWT.create()
                .withSubject(account.getId().toString())
                .withClaim("email", account.getEmail())
                .withClaim("name", account.getName().toString())
                .withClaim("state", account.getState().toString())
                .sign(Algorithm.HMAC256(secretKey));

        objectMapper.writeValue(response.getWriter(), Collections.singletonMap("token", token));
    }

}
