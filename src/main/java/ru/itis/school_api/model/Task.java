package ru.itis.school_api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student user;
    String text;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;
}
