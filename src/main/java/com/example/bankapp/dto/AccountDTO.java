package com.example.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;
import java.time.LocalDateTime;

@Value
public class AccountDTO {
    String name;
    String type;
    String status;
    String balance;
    String currency_code;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="dd.MM.yyyy HH:mm")
    String dataCreated;
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime updated_at;



}
