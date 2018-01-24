package br.com.estudospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudospring.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
