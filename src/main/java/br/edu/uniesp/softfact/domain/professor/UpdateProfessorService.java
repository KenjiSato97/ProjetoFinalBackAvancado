package br.edu.uniesp.softfact.domain.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorCreateRequest;
import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.application.professor.ProfessorUpdateRequest;

public interface UpdateProfessorService {

    ProfessorResponse criar(ProfessorCreateRequest domain);

    ProfessorResponse atualizar(Long id, ProfessorUpdateRequest domain);

    void excluir(Long id);
}
