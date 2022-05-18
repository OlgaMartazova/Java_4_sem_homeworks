package ru.itis.school_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.school_api.dto.SubjectDto;
import ru.itis.school_api.exception.ErrorEntity;
import ru.itis.school_api.mapper.SubjectMapper;
import ru.itis.school_api.model.Student;
import ru.itis.school_api.model.Subject;
import ru.itis.school_api.repository.SubjectsRepository;
import ru.itis.school_api.services.SubjectService;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectsRepository subjectsRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Subject subject = subjectMapper.getSubject(subjectDto);
        subject.setUser(student);
        Subject newSubject = subjectsRepository.save(subject);
        return subjectMapper.getDto(newSubject);
    }

    @Override
    public SubjectDto getSubject(Long id) {
        Optional<Subject> optionalSubject = subjectsRepository.findById(id);
        if (optionalSubject.isEmpty()) {
            throw new ValidationException(ErrorEntity.SUBJECT_NOT_FOUND.getMessage());
        }
        return subjectMapper.getDto(optionalSubject.get());
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        return subjectsRepository.findAll().stream()
                .map(subjectMapper::getDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubject(Long id) {
        Subject subject = subjectsRepository.findById(id)
                .orElseThrow(() -> new ValidationException(ErrorEntity.SUBJECT_NOT_FOUND.getMessage()));
        subjectsRepository.delete(subject);
    }
}
