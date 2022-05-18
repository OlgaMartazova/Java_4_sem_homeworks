package ru.itis.school_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school_api.dto.TaskDto;
import ru.itis.school_api.services.TaskService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.addTask(taskDto);
    }

    @GetMapping
    List<TaskDto> getAll() {
        return taskService.getAllAssignment();
    }
}
