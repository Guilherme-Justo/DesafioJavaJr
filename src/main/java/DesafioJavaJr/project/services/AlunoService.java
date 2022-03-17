package DesafioJavaJr.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DesafioJavaJr.project.entities.Aluno;
import DesafioJavaJr.project.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public Aluno create(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public Aluno getById(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.get();
	}
	
	public List<Aluno> getAll() {
		return repository.findAll();
	}
	
	public Aluno update(Long id, Aluno obj) {
		Aluno aluno = repository.getById(id);
		aluno.setNome(obj.getNome());
		aluno.setDataDeNascimento(obj.getDataDeNascimento());
		aluno.setTurma(obj.getTurma());
		return repository.save(aluno);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
