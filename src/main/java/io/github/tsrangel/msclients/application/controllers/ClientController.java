package io.github.tsrangel.msclients.application.controllers;

import io.github.tsrangel.msclients.application.dtos.client.requests.ClientRequestDTO;
import io.github.tsrangel.msclients.application.dtos.client.responses.ClientResponseDTO;
import io.github.tsrangel.msclients.application.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
@Slf4j
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public String index() {
        log.info("Obtendo o status do microserviço de clientes.");
        return "Welcome to the Client Service API!";
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<ClientResponseDTO> findClientByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok().body(clientService.findClientByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientRequestDTO dto) {
        ClientResponseDTO newClient = clientService.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(newClient.cpf()).toUri();
        return ResponseEntity.created(location).body(newClient);
    }
}
