package br.edu.uniesp.softfact.infra.professor;

import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "tb_softfact_professor",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_professor_email", columnNames = "email")
        })
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfessor;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

}

