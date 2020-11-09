package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> findAllUsuario(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> findByIdUsuario (@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping("/{id}")
	public Usuario putUsuario (@PathVariable Long id, @RequestBody Usuario objUsuario) {
		objUsuario.setId(id);
		repository.save(objUsuario);
		return objUsuario;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario (@PathVariable Long id) {
		repository.deleteById(id);
	}

}
