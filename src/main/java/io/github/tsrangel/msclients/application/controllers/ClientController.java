package io.github.tsrangel.msclients.application.controllers;

import io.github.tsrangel.msclients.application.dtos.client.requests.ClientRequestDTO;
import io.github.tsrangel.msclients.application.dtos.client.responses.ClientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {
    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getClientByCpf(@RequestParam String cpf) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody ClientRequestDTO dto) {
        return null;
    }
}
