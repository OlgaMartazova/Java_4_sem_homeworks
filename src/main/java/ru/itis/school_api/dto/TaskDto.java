package ru.itis.school_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    @NotBlank(message = "BLANK_TASK_DESCRIPTION")
    private String description;
    private SubjectDto subject;
    private List<AchievementDto> achievements;
}
