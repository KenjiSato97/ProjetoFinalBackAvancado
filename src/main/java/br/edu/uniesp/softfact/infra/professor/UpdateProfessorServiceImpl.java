package br.edu.uniesp.softfact.infra.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorCreateRequest;
import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.application.professor.ProfessorUpdateRequest;
import br.edu.uniesp.softfact.domain.professor.Professor;
import br.edu.uniesp.softfact.domain.professor.UpdateProfessorService;
import br.edu.uniesp.softfact.infra.mapper.ProfessorEntityMapper;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProfessorServiceImpl implements UpdateProfessorService {

    private final ProfessorRepository repo;
    private final ProfessorEntityMapper entityMapper;

    @Override
    public ProfessorResponse criar(ProfessorCreateRequest dto) {
        if (repo.existsByEmail(dto.email())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado.");
        }
        ProfessorEntity entity = entityMapper.toEntity(dto);
        var saved = repo.save(entity);
        return entityMapper.toResponse(saved);
    }

    @Override
    public ProfessorResponse atualizar(Long id, ProfessorUpdateRequest dto) {
        ProfessorEntity existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado: " + id));

        if (!existente.getEmail().equalsIgnoreCase(dto.email()) && repo.existsByEmail(dto.email())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado.");
        }

        existente.setNome(dto.nome());
        existente.setEmail(dto.email());


        return entityMapper.toResponse(existente);
    }

    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Professor não encontrado: " + id);
        repo.deleteById(id);
    }
}

