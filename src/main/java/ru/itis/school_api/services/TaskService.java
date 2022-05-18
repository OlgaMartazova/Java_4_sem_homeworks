package ru.itis.school_api.services;

import ru.itis.school_api.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);

    TaskDto getTask(Long id);

    List<TaskDto> getAllAssignment();
}
