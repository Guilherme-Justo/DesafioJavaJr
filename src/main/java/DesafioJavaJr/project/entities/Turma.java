package DesafioJavaJr.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer capacidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;
	
	public Turma() {
	}

	public Turma(Long id, String nome, Integer capacidade, Escola escola) {
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.escola = escola;
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

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
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
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Capacidade: " + capacidade;
	}
}
