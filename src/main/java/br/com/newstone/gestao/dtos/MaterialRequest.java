package br.com.newstone.gestao.dtos;

import br.com.newstone.gestao.enums.TipoMaterial;

import java.math.BigDecimal;

public record MaterialRequest(
        String name,
        TipoMaterial tipo,
        BigDecimal precoM2
) {}
