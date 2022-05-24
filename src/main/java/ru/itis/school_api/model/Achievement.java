package ru.itis.school_api.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "achievement")
public class Achievement extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;
    @Enumerated(EnumType.STRING)
    private Grade grade;
}
