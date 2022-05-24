package ru.itis.school_api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto {
    private Long id;
    private String name;
    @NotBlank(message = "BLANK_SUBJECT_DESCRIPTION")
    private String description;
    private List<TaskDto> assignment;
    private List<StudentDto> students;
}
