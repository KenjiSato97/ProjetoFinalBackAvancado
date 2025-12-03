package br.edu.uniesp.softfact.domain.professor;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    private Long id;
    private String nome;
    private String email;
}
