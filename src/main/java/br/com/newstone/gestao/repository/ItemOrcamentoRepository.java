package br.com.newstone.gestao.repository;

import br.com.newstone.gestao.entities.ItemOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, UUID> {

    List<ItemOrcamento> findByOrcamentoId(UUID orcamentoId);
}
