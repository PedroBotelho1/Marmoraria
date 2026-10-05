package br.com.newstone.gestao.repository;

import br.com.newstone.gestao.entities.Orcamento;
import br.com.newstone.gestao.enums.StatusOrcamento;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrcamentoRepository extends JpaRepository<OrcamentoRepository, UUID> {

    List<Orcamento> findByClienteId(UUID clienteId);

    List<Orcamento> findByStatus(StatusOrcamento status);
}
