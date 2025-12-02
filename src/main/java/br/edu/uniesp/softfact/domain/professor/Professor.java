package br.edu.uniesp.softfact.domain.professor;

import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    private Long idProfessor;
    private String nome;
    private String email;
}
