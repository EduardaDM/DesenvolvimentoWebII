package com.locadora.api.repository;
/*
(DAO): Utilizei interfaces que estendem o JpaRepository.
facilitou muito o desenvolvimento, pois o Spring já
entrega prontos os métodos de CRUD sem escrever SQL manual
 */
import com.locadora.api.model.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long> {

}
