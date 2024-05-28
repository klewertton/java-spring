package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;
    private AlunoRepository alunoRepository1;

    public void create(Aluno aluno){//criando um metodo para criar um aluno, para isso precisa de um parametro () o qual é o proprio aluno
        alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id){
        return alunoRepository.findById(id);
    }

    public void update(Long id, Aluno aluno){
        //Primeiro passo é procurar se o aluno existe.
        Optional<Aluno>alunoFromDb = findById(id);
        //Verificando se a variavel é vazia ou nao.
        if (alunoFromDb.isEmpty()){
            //Lança uma excecao caso nao encontre um aluno no banco de dados.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrato no Bando de Dados!");
        }

        //SE chegar ate aqui, significa que existe aluno.
        //Entao irei armazena-lo numa variavel.
        Aluno alunoUptaded = alunoFromDb.get();

        //PEGO a variavel criada "alunoUpdated" e faco os SETS necessarios para atualizar seus atributos.
        //alunoUpdated: Aluno que esta na memoria para ser atualizado.
        //Aluno: é o objeto java que anteriormente era im JSON vindo do Front.
        alunoUptaded.setName(aluno.getName());
        alunoUptaded.setEmail(aluno.getEmail());
        alunoUptaded.setCpf(aluno.getCpf());

        //Peguei a copia do aluno alterado na memoria RAM e devolvi esse aluno agora atualizado para o banco de dados
        alunoRepository.save(alunoUptaded);
    }

    public void deleteById(Long id){
        alunoRepository.deleteById(id);
    }
}
