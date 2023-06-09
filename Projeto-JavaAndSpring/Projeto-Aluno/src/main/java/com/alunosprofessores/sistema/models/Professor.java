package com.alunosprofessores.sistema.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tb_aluno SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status  = 'Ativo'")
@Table(name = "tb_professor")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Column(nullable = false, length = 100)
    @Email(message = "O e-mail informado não é válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Column(length = 10, nullable = false)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @NotNull(message = "A(s) disciplina(s) não pode ser nula(s)")
    private List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public String toString() {
        return "Professor: " + '\n' +
                "nome : " + getNome() + '\n' +
                "email : " + getEmail() + '\n' +
                "disciplinas : " + getDisciplinas();
    }
}
