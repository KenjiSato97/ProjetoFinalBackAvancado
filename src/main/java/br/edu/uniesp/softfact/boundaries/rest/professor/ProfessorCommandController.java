package br.edu.uniesp.softfact.boundaries.rest.professor;

import br.edu.uniesp.softfact.application.mappers.ProfessorCreateMapper;
import br.edu.uniesp.softfact.application.mappers.ProfessorUpdateMapper;
import br.edu.uniesp.softfact.application.professor.ProfessorCreateRequest;
import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.application.professor.ProfessorUpdateRequest;
import br.edu.uniesp.softfact.domain.professor.UpdateProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
public class ProfessorCommandController {

    private final UpdateProfessorService service;

    @PostMapping
    public ProfessorResponse criar(@RequestBody @Valid ProfessorCreateRequest request) {

        return service.criar(request);
    }

    @PutMapping("/{id}")
    public ProfessorResponse atualizar(@PathVariable Long id,
                                       @RequestBody @Valid ProfessorUpdateRequest request) {

        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

