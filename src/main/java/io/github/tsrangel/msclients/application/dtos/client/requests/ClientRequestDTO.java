package io.github.tsrangel.msclients.application.dtos.client.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClientRequestDTO(
        @CPF(message = "Cpf inválido.")
        @NotBlank(message = "Cpf é um campo obrigatório.")
        String cpf,
        @NotBlank(message = "Nome é um campo obrigatório.")
        String name,
        @Past(message = "Data de nascimento não pode ser uma data futura.")
        @NotNull(message = "Data de nascimento é um campo obrigatório.")
        LocalDate birthDate
) {
}
