package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.service.AccountService;
import com.example.bankapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(path = "{name}")
    public AccountDTO findByName(@PathVariable("name") String name) {
        return accountService.findByName(name);
    }

}
