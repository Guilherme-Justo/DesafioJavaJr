package DesafioJavaJr.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DesafioJavaJr.project.entities.Turma;
import DesafioJavaJr.project.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	public Turma create(Turma turma) {
		return repository.save(turma);
	}
	
	public Turma getById(Long id) {
		Optional<Turma> turma = repository.findById(id);
		return turma.get();
	}
	
	public List<Turma> getAll() {
		return repository.findAll();
	}
	
	public Turma update(Long id, Turma obj) {
		Turma turma = repository.getById(id);
		turma.setNome(obj.getNome());
		turma.setCapacidade(obj.getCapacidade());
		return repository.save(turma);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
