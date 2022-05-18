package ru.itis.school_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school_api.dto.TaskDto;
import ru.itis.school_api.exception.ErrorEntity;
import ru.itis.school_api.mapper.TaskMapper;
import ru.itis.school_api.model.Student;
import ru.itis.school_api.model.Subject;
import ru.itis.school_api.model.Task;
import ru.itis.school_api.repository.StudentsRepository;
import ru.itis.school_api.repository.SubjectsRepository;
import ru.itis.school_api.repository.TaskRepository;
import ru.itis.school_api.services.TaskService;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final StudentsRepository studentsRepository;
    private final SubjectsRepository subjectsRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final Validator validator;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Set<ConstraintViolation<TaskDto>> violations = validator.validate(taskDto);
        if (!violations.isEmpty()) {
            throw new ValidationException(violations.stream().findFirst().get().getMessage());
        }

        Optional<Student> optionalStudent = studentsRepository.findById(taskDto.getUserId());
        if (optionalStudent.isEmpty()) {
            throw new ValidationException(ErrorEntity.NOT_FOUND.getMessage());
        }

        Optional<Subject> optionalSubject = subjectsRepository.findById(taskDto.getSubject().getId());
        if (optionalSubject.isEmpty()) {
            throw new ValidationException(ErrorEntity.SUBJECT_NOT_FOUND.getMessage());
        }

        Task task = taskMapper.getTask(taskDto);
        task.setUser(optionalStudent.get());
        task.setSubject(optionalSubject.get());
        Task newTask = taskRepository.save(task);
        return taskMapper.getDto(newTask);
    }

    @Override
    public TaskDto getTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ValidationException(ErrorEntity.TASK_NOT_FOUND.getMessage());
        }
        return taskMapper.getDto(optionalTask.get());
    }

    @Override
    public List<TaskDto> getAllAssignment() {
            return taskRepository.findAll().stream()
                    .map(taskMapper::getDto)
                    .collect(Collectors.toList());
    }
}
