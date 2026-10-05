package br.com.newstone.gestao.repository;

import br.com.newstone.gestao.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {

    List<Pagamento> findByPedidoIdAndRecebidoFalse(UUID pedidoId);
}
