package br.com.newstone.gestao.controller;

import br.com.newstone.gestao.dtos.ClienteRequest;
import br.com.newstone.gestao.dtos.ClienteResponse;
import br.com.newstone.gestao.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> criar(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.criarCliente(clienteRequest);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarId(@PathVariable UUID id) {

        ClienteResponse response = clienteService.buscarId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<ClienteResponse> response = clienteService.listar();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteResponse>> buscarPorNome(@RequestParam String nome) {
        List<ClienteResponse> response = clienteService.buscarPorNome(nome);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable UUID id, @RequestBody ClienteRequest clienteRequest) {

        ClienteResponse response = clienteService.atualizar(id, clienteRequest);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        clienteService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
