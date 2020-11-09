package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long> {

	public List<Jogos> findAllByDescricaoContainingIgnoreCase(String descricao);
}
