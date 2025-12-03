package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.aluno.VincularAlunoRequest;
import br.edu.uniesp.softfact.application.stack.VincularStackRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.ProjetoCommandService;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoCommandServiceImpl implements ProjetoCommandService {

    private final ProjetoRepository repository;
    private final StackTecRepository stackRepository;
    private final AlunoRepository alunoRepository;

    @Override
    public Projeto save(Projeto projeto) {
        var entity = ProjetoEntityMapper.toEntity(projeto);
        return ProjetoEntityMapper.toDomain(repository.save(entity));
    }

    @Override
    public Projeto update(Long id, Projeto projeto) {
        ProjetoEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));

        existingEntity.setNome(projeto.getNome());
        existingEntity.setDescricao(projeto.getDescricao());
        existingEntity.setTipo(projeto.getTipo());
        existingEntity.setNomeEmpresa(projeto.getNomeEmpresa());
        existingEntity.setSemestre(projeto.getSemestre());
        existingEntity.setStatus(projeto.getStatus());
        existingEntity.setIdProfessor(projeto.getIdProfessor());

        var updatedEntity = repository.save(existingEntity);
        return ProjetoEntityMapper.toDomain(updatedEntity);
    }
    @Override
    @Transactional
    public ProjetoEntity vincularStack(Long projetoId, VincularStackRequest request) {
        ProjetoEntity projeto = repository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        StackTecnologia stack = stackRepository.findById(request.getStackId())
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));

        if (projeto.getStacks().contains(stack)) {
            throw new IllegalArgumentException("Stack já vinculada a este projeto");
        }

        projeto.getStacks().add(stack);
        return repository.save(projeto);
    }

    @Override
    @Transactional
    public ProjetoEntity desvincularStack(Long projetoId, VincularStackRequest request) {
        ProjetoEntity projeto = repository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        StackTecnologia stack = stackRepository.findById(request.getStackId())
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));

        if (!projeto.getStacks().contains(stack)) {
            throw new IllegalArgumentException("Stack não está vinculada a este projeto");
        }

        projeto.getStacks().remove(stack);
        return repository.save(projeto);
    }

    @Override
    @Transactional
    public ProjetoEntity vincularAluno(Long projetoId, VincularAlunoRequest request) {
        ProjetoEntity projeto = repository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        AlunoEntity aluno = alunoRepository.findById(request.getAlunoId())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        if (projeto.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno já vinculado a este projeto");
        }

        projeto.getAlunos().add(aluno);
        return repository.save(projeto);
    }

    @Override
    @Transactional
    public ProjetoEntity desvincularAluno(Long projetoId, VincularAlunoRequest request) {
        ProjetoEntity projeto = repository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        AlunoEntity aluno = alunoRepository.findById(request.getAlunoId())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        if (!projeto.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno não está vinculado a este projeto");
        }

        projeto.getAlunos().remove(aluno);
        return repository.save(projeto);
    }
}
