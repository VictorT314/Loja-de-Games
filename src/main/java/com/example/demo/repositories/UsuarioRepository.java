package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
