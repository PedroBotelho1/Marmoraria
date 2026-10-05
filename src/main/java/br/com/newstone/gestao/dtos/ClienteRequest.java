package br.com.newstone.gestao.dtos;

public record ClienteRequest(
        String nome,
        String cpf,
        String telefone,
        String endereco
) {}