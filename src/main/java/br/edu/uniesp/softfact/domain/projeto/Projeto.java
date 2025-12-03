package br.edu.uniesp.softfact.domain.projeto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projeto {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private String nomeEmpresa;
    private String semestre;
    private String status;
    private Long idProfessor;
}
