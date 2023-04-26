package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.models.dtos.ProfessorDto;
import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.repositorys.ProfessorRepository;
import com.alunosprofessores.sistema.services.IProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public Professor createProf(ProfessorDto professorDTO){
        Professor profNew = new Professor();
        profNew.setNome(professorDTO.getNome());
        profNew.setEmail(professorDTO.getEmail());
        return professorRepository.save(profNew);
    }

    public Professor getProfessor(Long id){
        return professorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Professor> getAllProf(){
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Long id, ProfessorDto professorAtt){
        Optional<Professor> professor = Optional.of(professorRepository.getReferenceById(id));
        BeanUtils.copyProperties(professorAtt, professor.get(), "id");
        Professor professorAtualizado = professorRepository.save(professor.get());
        return professorAtualizado;

    }
    public void deleteProf(Long id){
        professorRepository.delete(professorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}