package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "transaction")

public class Transaction {
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "debit_account_id", nullable = false)
    private Account debitAccount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "credit_account_id", nullable = false)
    private Account creditAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type;

    @Column(name = "amount", nullable = false, precision = 4)
    private BigDecimal amount;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", createAt=" + createdAt +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                '}';
    }
}