package ru.itis.school_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school_api.dto.SubjectDto;
import ru.itis.school_api.services.SubjectService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @GetMapping("/{id}")
    SubjectDto getById(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @GetMapping
    List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
