package com.citaexpressbk.demo.repository;

import com.citaexpressbk.demo.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    UserDetails findByUsername(String username);
}
