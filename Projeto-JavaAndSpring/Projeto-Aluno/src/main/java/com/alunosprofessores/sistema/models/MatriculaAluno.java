package com.alunosprofessores.sistema.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;
import java.util.Random;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_matriculaAluno")
public class MatriculaAluno implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int matricula;

    private Double nota1;

    private Double nota2;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "O ID do aluno não pode ser nulo")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @NotNull(message = "O ID da disciplina não pode ser nula")
    private Disciplina disciplina;

    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

    @Enumerated(EnumType.STRING)
    private StatusAluno statusAluno;


    public int gerarMatriculaAleatoria() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000;
        return numero;
    }
}
