package io.github.tsrangel.msclients.infra.repositories;

import io.github.tsrangel.msclients.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
