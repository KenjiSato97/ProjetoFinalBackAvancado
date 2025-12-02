package br.edu.uniesp.softfact.boundaries.rest.projeto;

import br.edu.uniesp.softfact.application.projeto.*;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.ProjetoCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
@RequiredArgsConstructor
public class ProjetoCommandController {

    private final ProjetoCommandService commandService;

    @PostMapping
    public ProjetoResponse criar(@RequestBody ProjetoCreateRequest request) {
        Projeto projeto = Projeto.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .tipo(request.getTipo())
                .nomeEmpresa(request.getNomeEmpresa())
                .semestre(request.getSemestre())
                .status(request.getStatus())
                .idProfessor(request.getIdProfessor())
                .build();

        var saved = commandService.save(projeto);

        return ProjetoResponse.builder()
                .idProjeto(saved.getIdProjeto())
                .nome(saved.getNome())
                .descricao(saved.getDescricao())
                .tipo(saved.getTipo())
                .nomeEmpresa(saved.getNomeEmpresa())
                .semestre(saved.getSemestre())
                .status(saved.getStatus())
                .idProfessor(saved.getIdProfessor())
                .build();
    }

    @PutMapping("/{id}")
    public ProjetoResponse atualizar(@PathVariable Long id, @RequestBody ProjetoUpdateRequest request) {

        Projeto projeto = Projeto.builder()
                .idProjeto(id)
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .tipo(request.getTipo())
                .nomeEmpresa(request.getNomeEmpresa())
                .semestre(request.getSemestre())
                .status(request.getStatus())
                .idProfessor(request.getIdProfessor())
                .build();

        var updated = commandService.update(projeto);

        return ProjetoResponse.builder()
                .idProjeto(updated.getIdProjeto())
                .nome(updated.getNome())
                .descricao(updated.getDescricao())
                .tipo(updated.getTipo())
                .nomeEmpresa(updated.getNomeEmpresa())
                .semestre(updated.getSemestre())
                .status(updated.getStatus())
                .idProfessor(updated.getIdProfessor())
                .build();
    }
}
