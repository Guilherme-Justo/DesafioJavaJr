package DesafioJavaJr.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DesafioJavaJr.project.entities.Escola;
import DesafioJavaJr.project.repositories.EscolaRepository;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository repository;
	
	public Escola create(Escola escola) {
		return repository.save(escola);
	}
	
	public Escola getById(Long id) {
		Optional<Escola> escola = repository.findById(id);
		return escola.get();
	}
	
	public List<Escola> getAll() {
		return repository.findAll();
	}
	
	public Escola update(Long id, Escola obj) {
		Escola escola = repository.getById(id);
		escola.setNome(obj.getNome());
		escola.setEndereco(obj.getEndereco());
		return repository.save(escola);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
