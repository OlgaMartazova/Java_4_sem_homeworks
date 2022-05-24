package ru.itis.school_api.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.school_api.repository.StudentsRepository;

@RequiredArgsConstructor
@Service
public class StudentAccountDetailsService implements UserDetailsService {
    private final StudentsRepository studentsRepository;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        return new StudentAccountDetails(studentsRepository.findByToken(token)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}
