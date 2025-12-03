package br.edu.uniesp.softfact.boundaries.rest.projeto;

import br.edu.uniesp.softfact.application.aluno.VincularAlunoRequest;
import br.edu.uniesp.softfact.application.projeto.*;
import br.edu.uniesp.softfact.application.stack.VincularStackRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.ProjetoCommandService;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
                .idProjeto(saved.getId())
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
                .id(id)
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .tipo(request.getTipo())
                .nomeEmpresa(request.getNomeEmpresa())
                .semestre(request.getSemestre())
                .status(request.getStatus())
                .idProfessor(request.getIdProfessor())
                .build();

        var updated = commandService.update(id, projeto);

        return ProjetoResponse.builder()
                .idProjeto(updated.getId())
                .nome(updated.getNome())
                .descricao(updated.getDescricao())
                .tipo(updated.getTipo())
                .nomeEmpresa(updated.getNomeEmpresa())
                .semestre(updated.getSemestre())
                .status(updated.getStatus())
                .idProfessor(updated.getIdProfessor())
                .build();
    }
    @PostMapping("/{projetoId}/stacks")
    public ResponseEntity<ProjetoEntity> vincularStack(
            @PathVariable Long projetoId,
            @Valid @RequestBody VincularStackRequest request) {
        try {
            ProjetoEntity projeto = commandService.vincularStack(projetoId, request);
            return ResponseEntity.ok(projeto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{projetoId}/stacks")
    public ResponseEntity<ProjetoEntity> desvincularStack(
            @PathVariable Long projetoId,
            @Valid @RequestBody VincularStackRequest request) {
        try {
            ProjetoEntity projeto = commandService.desvincularStack(projetoId, request);
            return ResponseEntity.ok(projeto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{projetoId}/alunos")
    public ResponseEntity<ProjetoEntity> vincularAluno(
            @PathVariable Long projetoId,
            @Valid @RequestBody VincularAlunoRequest request) {
        try {
            ProjetoEntity projeto = commandService.vincularAluno(projetoId, request);
            return ResponseEntity.ok(projeto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{projetoId}/alunos")
    public ResponseEntity<ProjetoEntity> desvincularAluno(
            @PathVariable Long projetoId,
            @Valid @RequestBody VincularAlunoRequest request) {
        try {
            ProjetoEntity projeto = commandService.desvincularAluno(projetoId, request);
            return ResponseEntity.ok(projeto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
