package ru.itis.school_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Integer number;
    @UniqueElements(message = "EMAIL_MUST_BE_UNIQUE")
    private String email;
    @NotBlank(message = "BLANK_PASSWORD")
    private String password;
    private List<SubjectDto> subjects;
    private List<AchievementDto> achievements;
}
