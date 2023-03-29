package com.example.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;
import java.time.LocalDateTime;

@Value
public class ClientDTO {

    String id;
    String manager;
    String status;
    String taxCode;
    String firstName;
    String lastName;
    String email;
    String address;
    String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    LocalDateTime birth_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime updated_at;

}
