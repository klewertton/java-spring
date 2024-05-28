package br.com.alunoonline.api.model;

import br.com.alunoonline.api.service.ProfessorService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Relacao entre a tabela disciplina e tabela professor.
    @ManyToOne//permitir que o banco de dados aceite muitas disciplinas para o mesmo professor
    @JoinColumn(name = "professor_id")//criacao de coluna na tabela disciplina com o ID do professor
    private Professor professor;

}
