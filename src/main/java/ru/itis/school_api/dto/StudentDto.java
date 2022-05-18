package ru.itis.school_api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Integer number;
}
