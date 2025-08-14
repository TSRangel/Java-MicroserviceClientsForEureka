package io.github.tsrangel.msclients.application.services;

import io.github.tsrangel.msclients.application.dtos.client.requests.ClientRequestDTO;
import io.github.tsrangel.msclients.application.dtos.client.responses.ClientResponseDTO;

public interface ClientService {
    ClientResponseDTO create(ClientRequestDTO dto);
    ClientResponseDTO findClientByCpf(String cpf);
}
