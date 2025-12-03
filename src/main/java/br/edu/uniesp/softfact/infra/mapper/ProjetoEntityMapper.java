package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;

public interface ProjetoEntityMapper {
    public static Projeto toDomain(ProjetoEntity entity) {
        if (entity == null) return null;

        return Projeto.builder()
                .id(entity.getIdProjeto())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .tipo(entity.getTipo())
                .nomeEmpresa(entity.getNomeEmpresa())
                .semestre(entity.getSemestre())
                .status(entity.getStatus())
                .idProfessor(entity.getIdProfessor())
                .build();
    }

    public static ProjetoEntity toEntity(Projeto projeto) {
        return ProjetoEntity.builder()
                .nome(projeto.getNome())
                .descricao(projeto.getDescricao())
                .tipo(projeto.getTipo())
                .nomeEmpresa(projeto.getNomeEmpresa())
                .semestre(projeto.getSemestre())
                .status(projeto.getStatus())
                .idProfessor(projeto.getIdProfessor())
                .build();
    }
}
