package ru.itis.school_api.services;

import ru.itis.school_api.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto addSubject(SubjectDto subjectDto);

    SubjectDto getSubject(Long id);

    List<SubjectDto> getAllSubjects();

    void deleteSubject(Long id);
}
