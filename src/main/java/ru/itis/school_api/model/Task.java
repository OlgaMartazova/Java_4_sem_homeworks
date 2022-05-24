package ru.itis.school_api.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assignment")
public class Task extends AbstractEntity {
    private String description;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToMany(mappedBy = "task")
    private List<Achievement> achievements;
}
