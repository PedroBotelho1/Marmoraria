package br.com.newstone.gestao.repository;

import br.com.newstone.gestao.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    boolean existsByNameOrCpf(String nome, String cpf);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
