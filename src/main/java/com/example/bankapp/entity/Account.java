package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.CurrencyType;
import jakarta.persistence.*;


import com.example.bankapp.entity.enums.AccountStatus;
import com.example.bankapp.entity.enums.AccountType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")

public class Account {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AccountStatus status;
    @Column(name = "balance", nullable = false, precision = 2)
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_code", nullable = false)
    private CurrencyType currencyCode;
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "account")
    private Set<Agreement> agreements;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "debitAccount")
    private Set<Transaction> debitTransactionList;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "creditAccount")
    private Set<Transaction> creditTransactionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) && client.equals(account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", balance=" + balance +
                ", currencyCode=" + currencyCode +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}