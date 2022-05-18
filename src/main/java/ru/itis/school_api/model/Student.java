package ru.itis.school_api.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

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
    @Column(unique = true)
    private String number;
    private String token;
}
