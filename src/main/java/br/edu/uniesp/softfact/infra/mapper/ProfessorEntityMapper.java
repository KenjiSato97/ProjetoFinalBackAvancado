package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.professor.ProfessorCreateRequest;
import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.domain.professor.Professor;
import br.edu.uniesp.softfact.infra.professor.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorEntityMapper {

    ProfessorEntity toEntity(ProfessorCreateRequest dto);

    ProfessorResponse toResponse(ProfessorEntity entity);
}
