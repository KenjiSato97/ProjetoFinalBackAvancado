package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;

public interface StackCommandService {
    StackTecnologia create(StackCreateRequest request);
    StackTecnologia update(Long id, StackUpdateRequest request);
    void delete(Long id);
}