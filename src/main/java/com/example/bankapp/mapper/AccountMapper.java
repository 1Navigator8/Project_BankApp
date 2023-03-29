package com.example.bankapp.mapper;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO toDto(Account account);
}