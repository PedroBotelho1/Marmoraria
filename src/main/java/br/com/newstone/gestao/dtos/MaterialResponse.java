package br.com.newstone.gestao.dtos;

import br.com.newstone.gestao.enums.TipoMaterial;

import java.math.BigDecimal;
import java.util.UUID;

public record MaterialResponse(
        UUID id,
        String name,
        TipoMaterial tipo,
        BigDecimal precoM2,
        boolean ativo
) {
}
