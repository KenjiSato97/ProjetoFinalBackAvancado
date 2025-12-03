package br.edu.uniesp.softfact.domain.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;

public interface ProjetoCommandService {
    Projeto save(Projeto projeto);
    Projeto update(Projeto projeto);
}
