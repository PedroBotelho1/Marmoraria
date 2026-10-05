package br.com.newstone.gestao.service;

import br.com.newstone.gestao.dtos.ClienteRequest;
import br.com.newstone.gestao.dtos.ClienteResponse;
import br.com.newstone.gestao.entities.Cliente;
import br.com.newstone.gestao.mapper.ClienteMapper;
import br.com.newstone.gestao.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toEntity(clienteRequest);
        Cliente salvo = clienteRepository.save(cliente);
        return clienteMapper.toResponse(salvo);
    }

    public ClienteResponse buscarId(UUID id) {
        Cliente clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return clienteMapper.toResponse(clienteEntity);
    }

    public List<ClienteResponse> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> clienteMapper.toResponse(cliente))
                .toList();
    }

    public List<ClienteResponse> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(cliente -> clienteMapper.toResponse(cliente))
                .toList();
    }

    public ClienteResponse atualizar(UUID id, ClienteRequest clienteRequest) {
        Cliente clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteEntity.setNome(clienteRequest.nome());
        clienteEntity.setCpf(clienteRequest.cpf());
        clienteEntity.setTelefone(clienteRequest.telefone());
        clienteEntity.setEndereco(clienteRequest.endereco());

        Cliente salvo = clienteRepository.save(clienteEntity);
        return clienteMapper.toResponse(salvo);
    }

    public void deletar(UUID id) {
        Cliente clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(clienteEntity);
    }
}
