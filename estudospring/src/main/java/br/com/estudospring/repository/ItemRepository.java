package br.com.estudospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.estudospring.models.Item;

@RepositoryRestResource(collectionResourceRel="itens", path="itens")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
