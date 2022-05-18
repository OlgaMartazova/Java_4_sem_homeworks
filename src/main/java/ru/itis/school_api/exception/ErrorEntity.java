package ru.itis.school_api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorEntity {
    // Общие ошибки
    INVALID_REQUEST(0, "Неверный запрос"),
    INVALID_TOKEN(1, "Ошибка авторизации"),
    NOT_FOUND(2, "Не найдено"),
    EMAIL_ALREADY_TAKEN(3, "Email уже занят"),


    // Ошибка добавления предмета
    BLANK_SUBJECT_NAME(4, "Имя не может быть пустым"),
    BLANK_SUBJECT_DESCRIPTION(5, "Поле description не может быть пустым"),

    // Получение предмета
    SUBJECT_NOT_FOUND(6, "Предмет не найдена"),

    // Ошибка добавления задания
    BLANK_TASK_TEXT(7, "Задание не может быть пустым"),

    // Получение задания
    TASK_NOT_FOUND(8, "Задание не найдено"),

    ;
    int status;
    String message;

    ErrorEntity(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
