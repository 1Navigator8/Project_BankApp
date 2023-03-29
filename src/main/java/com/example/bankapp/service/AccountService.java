package com.example.bankapp.service;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.mapper.AccountMapper;
import com.example.bankapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountDTO findByName(String name) {
        return accountMapper.
                toDto(accountRepository.
                        findAccountByName(name).
                        orElseThrow(() ->
                                new IllegalStateException("Account with name: "  +
                                        name + " doesn't exist in the DataBase")));
    }
}

