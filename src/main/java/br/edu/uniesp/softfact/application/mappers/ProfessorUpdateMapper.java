package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.professor.ProfessorUpdateRequest;
import br.edu.uniesp.softfact.domain.professor.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorUpdateMapper {

    Professor toDomain(ProfessorUpdateRequest request);
}
