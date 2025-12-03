package br.edu.uniesp.softfact.boundaries.rest.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.ProjetoQueryService;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
@RequiredArgsConstructor
public class ProjetoQueryController {

    private final ProjetoQueryService queryService;

    @GetMapping("/{id}")
    public ProjetoResponse find(@PathVariable Long id) {
        var projeto = queryService.findById(id);

        return ProjetoResponse.builder()
                .idProjeto(projeto.getId())
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
