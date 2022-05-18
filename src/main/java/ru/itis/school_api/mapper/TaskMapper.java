package ru.itis.school_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school_api.dto.TaskDto;
import ru.itis.school_api.model.Task;

@Mapper(uses = {TaskMapper.class})
public interface TaskMapper {
    @Mapping(target = "subject", ignore = true)
    TaskDto getDto(Task task);

    @Mapping(target = "subject", ignore = true)
    Task getTask(TaskDto taskDto);
}
