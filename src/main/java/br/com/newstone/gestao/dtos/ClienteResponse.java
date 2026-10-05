package br.com.newstone.gestao.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClienteResponse(
        UUID id,
        String nome,
        String telefone,
        String endereco,
        LocalDateTime criadoEm
) {}
