package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Jogos;
import com.example.demo.repositories.JogosRepository;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JogosController {

	@Autowired
	private JogosRepository repository;
	
	@GetMapping
	public List<Jogos> findAllProduto(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Jogos> findByIdProduto (@PathVariable Long id){
		return repository.findById(id);
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Jogos>> findByDescricaoProduto (@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Jogos> post (@RequestBody Jogos jogo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogo));
	}
	
	@PutMapping("/{id}")
	public Jogos putProduto (@PathVariable Long id, @RequestBody Jogos objJogos) {
		objJogos.setId(id);
		repository.save(objJogos);
		return objJogos;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto (@PathVariable Long id) {
		repository.deleteById(id);
	}
}
