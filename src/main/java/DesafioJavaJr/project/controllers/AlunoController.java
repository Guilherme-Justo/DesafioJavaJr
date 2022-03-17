package DesafioJavaJr.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import DesafioJavaJr.project.entities.Aluno;
import DesafioJavaJr.project.entities.Turma;
import DesafioJavaJr.project.services.AlunoService;
import DesafioJavaJr.project.services.TurmaService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@ModelAttribute("turmas")
	public List<Turma> turmas() {
		return turmaService.getAll();
	}
	
	@GetMapping("/alunos/cadastro")
	public String CreateView(@ModelAttribute("aluno") Aluno aluno) {
		return "/Alunos/CadastroAluno";
	}
	
	@PostMapping("/alunos/salvar")
	public String Create(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/Alunos/CadastroAluno";
		}
		alunoService.create(aluno);
		return "redirect:/alunos";
	}
	
	@GetMapping("/alunos")
	public String getAll(Model model) {
		model.addAttribute("Alunos", alunoService.getAll());
		return "/Alunos/Index";
	}
	
	@GetMapping(value = "/alunos/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable Long id) {
		Aluno aluno = alunoService.getById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping(value = "/alunos/{id}")
	public ResponseEntity<Aluno> Update(@PathVariable Long id, @RequestBody Aluno aluno) {
		aluno = alunoService.update(id, aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@DeleteMapping(value = "/alunos/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
