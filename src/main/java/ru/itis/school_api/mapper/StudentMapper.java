package ru.itis.school_api.mapper;

import org.mapstruct.Mapper;
import ru.itis.school_api.dto.StudentDto;
import ru.itis.school_api.model.Student;

@Mapper
public interface StudentMapper {
    StudentDto getDto(Student student);

    Student getStudent(StudentDto studentDto);
}
