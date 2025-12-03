package br.edu.uniesp.softfact.domain.projeto;

import br.edu.uniesp.softfact.application.aluno.VincularAlunoRequest;
import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;
import br.edu.uniesp.softfact.application.stack.VincularStackRequest;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;

public interface ProjetoCommandService {
    Projeto save(Projeto projeto);
    Projeto update(Long id, Projeto projeto);

    ProjetoEntity vincularAluno(Long projetoId, VincularAlunoRequest request);
    ProjetoEntity desvincularAluno(Long projetoId, VincularAlunoRequest request);

    ProjetoEntity vincularStack(Long projetoId, VincularStackRequest request);
    ProjetoEntity desvincularStack(Long projetoId, VincularStackRequest request);
}
