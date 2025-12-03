package br.edu.uniesp.softfact.infra.projeto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_softfact_projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long idProjeto;

    private String nome;
    private String descricao;
    private String tipo;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    private String semestre;
    private String status;

    @Column(name = "id_professor")
    private Long idProfessor;
}
