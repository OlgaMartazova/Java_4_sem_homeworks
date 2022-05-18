package ru.itis.school_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school_api.dto.SubjectDto;
import ru.itis.school_api.model.Subject;

@Mapper(uses = {StudentMapper.class})
public interface SubjectMapper {
    @Mapping(target = "assignment", ignore = true)
    SubjectDto getDto(Subject subject);

    @Mapping(target = "assignment", ignore = true)
    Subject getSubject(SubjectDto subjectDto);
}
