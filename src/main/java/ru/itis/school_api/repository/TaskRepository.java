package ru.itis.school_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school_api.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
