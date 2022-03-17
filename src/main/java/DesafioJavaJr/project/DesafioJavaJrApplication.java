package DesafioJavaJr.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import DesafioJavaJr.project.repositories.AlunoRepository;
import DesafioJavaJr.project.repositories.EscolaRepository;
import DesafioJavaJr.project.repositories.TurmaRepository;

@EnableWebMvc
@SpringBootApplication
public class DesafioJavaJrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaJrApplication.class, args);
	}

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Seeding para teste, caso seja interessante:
		
		/*
		Escola e1 = new Escola(null, "FAETEC", new Endereco("Rua Haroldo Vidal", "QD28 LT05", "Areal", "Itaboraí", "RJ")); 
			
		Turma t1 = new Turma(null, "1001", 30, e1);
		Turma t2 = new Turma(null, "1002", 35, e1);
			
		Aluno a1 = new Aluno(null, "Guilherme", LocalDate.of(1991, 8, 9), t1);
		Aluno a2 = new Aluno(null, "Sara", LocalDate.of(2002, 9, 23), t1);
		Aluno a3 = new Aluno(null, "Nádia", LocalDate.of(1962, 10, 31), t1);
		Aluno a4 = new Aluno(null, "Rogério", LocalDate.of(1983, 11, 20), t2);
		Aluno a5 = new Aluno(null, "Antônio", LocalDate.of(1957, 7, 14), t2);
			
		escolaRepository.saveAll(Arrays.asList(e1));
		turmaRepository.saveAll(Arrays.asList(t1, t2));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));	
		*/	
	}
}
