package DesafioJavaJr.project.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo \"nome\" não pode ser vazio.")
	private String nome;
	
	@NotNull(message = "O campo \"data de nascimento\" não pode ser vazio.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeNascimento;
	
	@NotNull(message = "O campo \"turma\" não pode ser vazio.")
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public Aluno() {
	}

	public Aluno(Long id, String nome, LocalDate dataDeNascimento, Turma turma) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + "]";
	}
}
