package ru.itis.school_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school_api.model.Student;

import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNumber(String number);

    Optional<Student> findByToken(String token);
}
