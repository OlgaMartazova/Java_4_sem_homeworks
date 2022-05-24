package ru.itis.school_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school_api.model.Grade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AchievementDto {
    private Long id;
    private StudentDto student;
    private TaskDto task;
    private Grade grade;
}
