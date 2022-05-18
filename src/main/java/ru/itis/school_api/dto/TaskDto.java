package ru.itis.school_api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    StudentDto user;
    @NotNull(message = "STUDENT_ID_EMPTY")
    private Long userId;
    @NotBlank(message = "BLANK_COMMENT_TEXT")
    String text;
    SubjectDto subject;
}
