package com.alunosprofessores.sistema.dtos;

import com.alunosprofessores.sistema.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorForm {

    private String nome;
    private String email;
}
