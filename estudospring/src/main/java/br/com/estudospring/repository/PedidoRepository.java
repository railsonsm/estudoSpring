package br.com.estudospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudospring.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
