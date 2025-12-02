package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.professor.ProfessorCreateRequest;
import br.edu.uniesp.softfact.domain.professor.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorCreateMapper {

    Professor toDomain(ProfessorCreateRequest request);
}
