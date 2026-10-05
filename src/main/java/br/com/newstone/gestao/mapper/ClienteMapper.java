package br.com.newstone.gestao.mapper;

import br.com.newstone.gestao.dtos.ClienteRequest;
import br.com.newstone.gestao.dtos.ClienteResponse;
import br.com.newstone.gestao.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper{

    public Cliente toEntity(ClienteRequest clienteRequest) {
        Cliente clienteEntity = new Cliente();

        clienteEntity.setNome(clienteRequest.nome());
        clienteEntity.setCpf(clienteRequest.cpf());
        clienteEntity.setTelefone(clienteRequest.telefone());
        clienteEntity.setEndereco(clienteRequest.endereco());
        return clienteEntity;
    }

    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getCriadoEm()
        );
    }
}
