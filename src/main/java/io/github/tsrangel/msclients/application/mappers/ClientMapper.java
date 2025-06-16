package io.github.tsrangel.msclients.application.mappers;

import io.github.tsrangel.msclients.application.dtos.client.requests.ClientRequestDTO;
import io.github.tsrangel.msclients.application.dtos.client.responses.ClientResponseDTO;
import io.github.tsrangel.msclients.domain.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientResponseDTO toDTO(Client client);
    Client toDomain(ClientRequestDTO dto);
}
