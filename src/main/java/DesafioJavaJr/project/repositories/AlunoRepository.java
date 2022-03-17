package DesafioJavaJr.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import DesafioJavaJr.project.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
