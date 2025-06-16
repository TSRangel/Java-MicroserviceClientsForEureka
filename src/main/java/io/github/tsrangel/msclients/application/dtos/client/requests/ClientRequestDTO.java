package io.github.tsrangel.msclients.application.dtos.client.requests;

import java.time.LocalDate;

public record ClientRequestDTO(
        String cpf,
        String name,
        LocalDate birthDate
) {
}
