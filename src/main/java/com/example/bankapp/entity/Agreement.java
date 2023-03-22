package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.AccountProductStatus;
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
@Table(name = "agreement")

public class Agreement {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Column(name = "interest_rate", nullable = false, precision = 4)
    private BigDecimal interestRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AccountProductStatus status;

    @Column(name = "sum", nullable = false, precision = 2)
    private BigDecimal sum;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id.equals(agreement.id) && account.equals(agreement.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", product=" + product +
                ", account=" + account +
                '}';
    }
}