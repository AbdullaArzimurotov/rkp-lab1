package ru.kafpin.laboratoriya;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Student(
        @NotNull(message = "Укажите идентификатор.") @Positive(message = "Идентификатор должен быть положительным.") Long id,
        @NotBlank(message = "Укажите фамилию.") String surname,
        @NotBlank(message = "Укажите имя.") String name,
        @NotBlank(message = "Укажите отчество.") String patronymic,
        @NotBlank(message = "Укажите адрес почты.") @Email(message = "Введите корректный адрес почты.") String email,
        @NotNull(message = "Укажите год поступления.")
        @Min(value = 1900, message = "Укажите год не ранее 1900.")
        @Max(value = 2100, message = "Укажите год не позднее 2100.") Integer enrollmentYear) {

    public String getGroupName() {
        return "ПИНз-1%02d".formatted(enrollmentYear % 100);
    }

    public String getLogin() {
        return "student-pinz1%02d-%d".formatted(enrollmentYear % 100, id);
    }
}
