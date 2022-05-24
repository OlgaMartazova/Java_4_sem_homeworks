package ru.itis.school_api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student extends AbstractEntity implements Serializable {
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_surname")
    private String surname;
    private String email;
    private String password;
    @Column(unique = true)
    private String number;
    private String token;
    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    private List<Subject> subjects;
    @OneToMany(mappedBy = "student")
    private List<Achievement> achievements;
    @Enumerated(value = EnumType.STRING)
    private State state;
}
