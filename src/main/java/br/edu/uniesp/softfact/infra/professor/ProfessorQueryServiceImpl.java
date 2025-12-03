package br.edu.uniesp.softfact.infra.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.domain.professor.ProfessorQueryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfessorQueryServiceImpl implements ProfessorQueryService {

    private final ProfessorRepository repo;

    @Transactional(readOnly = true)
    @Override
    public ProfessorResponse buscarPorId(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado: " + id));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProfessorResponse> listar(String termo, Pageable pageable) {
        Page<ProfessorEntity> page;

        if (termo == null || termo.isBlank()) {
            page = repo.findAll(pageable);
        } else {
            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                    .withIgnoreNullValues()
                    .withMatcher("nome", m -> m.contains().ignoreCase())
                    .withMatcher("email", m -> m.contains().ignoreCase());

            ProfessorEntity probe = new ProfessorEntity();
            probe.setNome(termo);
            probe.setEmail(termo);

            page = repo.findAll(Example.of(probe, matcher), pageable);
        }

        return page.map(this::toResponse);
    }

    private ProfessorResponse toResponse(ProfessorEntity e) {
        return new ProfessorResponse(
                e.getId(),
                e.getNome(),
                e.getEmail()
        );
    }
}
