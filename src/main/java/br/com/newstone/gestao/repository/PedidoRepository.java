package br.com.newstone.gestao.repository;

import br.com.newstone.gestao.entities.Pagamento;
import br.com.newstone.gestao.entities.Pedido;
import br.com.newstone.gestao.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    List<Pagamento> findByStatus(StatusPedido status);
}
