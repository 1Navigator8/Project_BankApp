package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")

public class Client {
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClientStatus status;

    @Column(name = "tax_code", nullable = false, length = 20)
    private String taxCode;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    @ToString.Exclude
    private Set<Account> accountList;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && email.equals(client.email) && phone.equals(client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", status=" + status +
                ", taxCode='" + taxCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", manager=" + manager +
                '}';
    }
}