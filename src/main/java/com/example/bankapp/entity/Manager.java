package com.example.bankapp.entity;
import com.example.bankapp.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "manager")

public class Manager {
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ManagerStatus status;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "manager")
    @ToString.Exclude
    private Set<Client> clients;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "manager")
    @ToString.Exclude
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id.equals(manager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}