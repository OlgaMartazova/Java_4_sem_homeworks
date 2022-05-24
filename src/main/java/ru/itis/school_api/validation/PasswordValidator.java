package ru.itis.school_api.validation;

import org.springframework.data.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements ConstraintValidator<PaswordAnnotation, Object> {
    private String[] fields;

    @Override
    public void initialize(PaswordAnnotation constraintAnnotation) {
        this.fields = constraintAnnotation.passwords();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        List<String> fieldValues = new ArrayList<>();

        for (String fieldName : fields) {
            try {
                Field field = ReflectionUtils.findRequiredField(object.getClass(), fieldName);
                field.setAccessible(true);
                fieldValues.add((String) field.get(object));
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return fieldValues.size() == fieldValues.stream().distinct().count();
    }
}
