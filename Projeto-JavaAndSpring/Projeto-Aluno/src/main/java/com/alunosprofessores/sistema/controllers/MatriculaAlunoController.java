package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.models.dtos.HistoricoAlunoDto;
import com.alunosprofessores.sistema.models.dtos.NotasAlunosDto;
import com.alunosprofessores.sistema.services.IMatriculaAlunoService;
import com.alunosprofessores.sistema.services.Impl.MatriculaAlunoImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoImpl matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> create(@RequestBody MatriculaAluno matriculaAluno){
        MatriculaAluno matriculaAluno1 = matriculaAlunoService.create(matriculaAluno);
        return ResponseEntity.status(201).body(matriculaAluno1);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatriculaAluno getOne(@PathVariable @Positive Long id){
        return matriculaAlunoService.getMatriculaAluno(id);
    }

    @GetMapping("/listarMatriculas")
    @ResponseStatus(HttpStatus.OK)
    public List<MatriculaAluno> getAll(){
        return matriculaAlunoService.getAll();
    }

    @PutMapping("/updateMatricula/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatematricula(@PathVariable @Positive Long id){
        matriculaAlunoService.updateMatricula(id);
    }

    @PutMapping("/updateNotas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateNotasAluno(@PathVariable @Positive Long id, @RequestBody NotasAlunosDto notasAlunosDto){
        matriculaAlunoService.updateNotasAluno(id,notasAlunosDto);
    }

    @GetMapping("/historicoAluno/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<HistoricoAlunoDto> historicoAlunoDto(@PathVariable @Positive Long id){
        return matriculaAlunoService.historicoAlunos(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatricula(@PathVariable @Positive Long id){
        matriculaAlunoService.deleteMatriculaAluno(id);
    }



}
