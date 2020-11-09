package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{


	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
