package com.locadora.api.repository;

import com.locadora.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    // Retorna o Usuario direto ou Optional, sem UserDetails
    Optional<Usuario> findByLogin(String login);

}
