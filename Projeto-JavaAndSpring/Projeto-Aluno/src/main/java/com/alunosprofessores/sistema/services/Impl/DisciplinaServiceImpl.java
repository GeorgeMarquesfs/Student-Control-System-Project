package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.repositorys.DisciplinaRepository;
import com.alunosprofessores.sistema.services.IDisciplinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DisciplinaServiceImpl implements IDisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;


    public Disciplina getDisciplina(Long id){
        return disciplinaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Disciplina> getAll(){
        return disciplinaRepository.findAll();
    }

    public Disciplina updateDisciplina(Long id, Disciplina disciplinaAtt){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        BeanUtils.copyProperties(disciplinaAtt, disciplina, "id");
        Disciplina disciplinaAtualizada = disciplinaRepository.save(disciplina);
        return disciplinaAtualizada;
    }

    public void deleteDisciplina(Long id){
        disciplinaRepository.delete(disciplinaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
