package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.service.AccountServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountServiceInterface accountService;




}
