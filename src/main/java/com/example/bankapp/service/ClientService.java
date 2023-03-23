package com.example.bankapp.service;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.mapper.ClientMapper;
import com.example.bankapp.entity.Client;
import com.example.bankapp.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;


    public List<Client> getClients() {
        List<Client> result = clientRepository.findAll();
        System.out.println("\n\n\n" + result + "\n\nResult");
        return clientRepository.findAll();
    }

    @Transactional
    public ClientDTO findClientByName(String name) {
        return clientMapper.toDto(
                clientRepository.findClientByFirstName(name).orElseThrow(() -> new IllegalStateException("Client with name: " + name + " doesn't exists in database")));
    }
}
