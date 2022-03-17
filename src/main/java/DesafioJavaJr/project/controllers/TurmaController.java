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

import DesafioJavaJr.project.entities.Turma;
import DesafioJavaJr.project.services.TurmaService;

@Controller
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@PostMapping(value = "/turmas")
	public ResponseEntity<Turma> Create(@RequestBody Turma turma) {
		turmaService.create(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).body(turma);
	}
	
	@GetMapping(value = "/turmas")
	public ResponseEntity<List<Turma>> getAll() {
		List<Turma> list = turmaService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/turmas/{id}")
	public ResponseEntity<Turma> getById(@PathVariable Long id) {
		Turma turma = turmaService.getById(id);
		return ResponseEntity.ok().body(turma);
	}
	
	@PutMapping(value = "/turmas/{id}")
	public ResponseEntity<Turma> update(@PathVariable Long id, @RequestBody Turma turma) {
		turma = turmaService.update(id, turma);
		return ResponseEntity.ok().body(turma);
	}
	
	@DeleteMapping(value = "/turmas/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		turmaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
