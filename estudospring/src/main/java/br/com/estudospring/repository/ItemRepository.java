package br.com.estudospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudospring.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
