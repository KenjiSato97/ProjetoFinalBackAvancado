package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "tb_softfact_projeto_aluno",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<AlunoEntity> alunos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_softfact_projeto_stack",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "stack_id"))
    private Set<StackTecnologia> stacks = new HashSet<>();
}
