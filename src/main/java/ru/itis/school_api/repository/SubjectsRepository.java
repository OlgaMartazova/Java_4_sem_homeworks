package ru.itis.school_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school_api.model.Subject;

public interface SubjectsRepository extends JpaRepository<Subject, Long> {
}
