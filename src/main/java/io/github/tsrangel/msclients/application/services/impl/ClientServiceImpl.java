package io.github.tsrangel.msclients.application.services.impl;

import io.github.tsrangel.msclients.application.dtos.client.requests.ClientRequestDTO;
import io.github.tsrangel.msclients.application.dtos.client.responses.ClientResponseDTO;
import io.github.tsrangel.msclients.application.mappers.ClientMapper;
import io.github.tsrangel.msclients.application.services.ClientService;
import io.github.tsrangel.msclients.application.services.exceptions.ResourceAlreadyExistsException;
import io.github.tsrangel.msclients.application.services.exceptions.ResourceNotFoundException;
import io.github.tsrangel.msclients.domain.entities.Client;
import io.github.tsrangel.msclients.infra.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Transactional
    @Override
    public ClientResponseDTO create(ClientRequestDTO dto) {
        if(clientRepository.findByCpf(dto.cpf()).isPresent()) {
            throw new ResourceAlreadyExistsException("Cliente com CPF " + dto.cpf() + " já cadastrado.");
        }

        Client newClient = clientRepository.save(clientMapper.toDomain(dto));
        return clientMapper.toDTO(newClient);
    }

    @Override
    public ClientResponseDTO findClientByCpf(String cpf) {
        return clientMapper.toDTO(clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com CPF " + cpf + " não encontrado.")));
    }
}
