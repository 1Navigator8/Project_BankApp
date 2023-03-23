package com.example.bankapp.mapper;


import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(Client client);

    default String map(Manager manager) {
        return manager.toString();
    }
}
