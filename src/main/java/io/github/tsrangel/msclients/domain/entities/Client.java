package io.github.tsrangel.msclients.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@SuperBuilder
@Table(name = "tb_client")
@NoArgsConstructor
public class Client extends BaseEntity {
    private String cpf;
    private String name;
    private LocalDate birthDate;
}
