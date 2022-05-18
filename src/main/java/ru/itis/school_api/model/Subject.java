package ru.itis.school_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject extends AbstractEntity {
    String name;
    String description;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student user;
    @OneToMany(mappedBy = "subject")
    List<Task> assignment;
}
