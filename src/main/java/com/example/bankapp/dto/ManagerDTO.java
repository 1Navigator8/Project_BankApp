package com.example.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;
import java.time.LocalDateTime;
@Value
public class ManagerDTO {

    String firstName;
    String lastName;
    String status;
    String email;
    String phone_number;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    LocalDateTime birth_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime updated_at;

}
