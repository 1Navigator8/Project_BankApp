package com.example.bankapp.repository;

import com.example.bankapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ClientRepository  extends JpaRepository<Client, UUID> {

    @Query("SELECT m FROM Client m WHERE m.firstName=?1")
    Optional<Client> findClientByFirstName(String firstName);

    @Query("SELECT m FROM Client m WHERE m.firstName=?1 and m.lastName=?2")
    Optional<Client> findClientByFullName(String firstName, String lastName);


}
