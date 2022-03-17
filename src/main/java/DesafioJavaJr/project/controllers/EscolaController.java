package DesafioJavaJr.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import DesafioJavaJr.project.entities.Escola;
import DesafioJavaJr.project.services.EscolaService;

@Controller
public class EscolaController {

	@Autowired
	private EscolaService escolaService;
	
	@PostMapping(value = "/escolas")
	public ResponseEntity<Escola> Create(@RequestBody Escola escola) {
		escolaService.create(escola);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(escola.getId()).toUri();
		return ResponseEntity.created(uri).body(escola);
	}
	
	@GetMapping(value = "/escolas")
	public ResponseEntity<List<Escola>> getAll() {
		List<Escola> list = escolaService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/escolas/{id}")
	public ResponseEntity<Escola> getById(@PathVariable Long id) {
		Escola escola = escolaService.getById(id);
		return ResponseEntity.ok().body(escola);
	}
	
	@PutMapping(value = "/escolas/{id}")
	public ResponseEntity<Escola> update(@PathVariable Long id, @RequestBody Escola escola) {
		escola = escolaService.update(id, escola);
		return ResponseEntity.ok().body(escola);
	}
	
	@DeleteMapping(value = "/escolas/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		escolaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
