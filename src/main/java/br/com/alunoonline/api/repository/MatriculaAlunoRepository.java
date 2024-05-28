package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    List<Aluno> findByAlunoId(Long alunoId);
    List<Aluno> findByDisciplinaId(Long disciplinaId);

}
