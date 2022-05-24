package ru.itis.school_api.mapper;

import org.mapstruct.Mapper;
import ru.itis.school_api.dto.AchievementDto;
import ru.itis.school_api.model.Achievement;

@Mapper
public interface AchievementMapper {
    Achievement getAchievement(AchievementDto achievementDto);

    AchievementDto getDto(Achievement achievement);
}
