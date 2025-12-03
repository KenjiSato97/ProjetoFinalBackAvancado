package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.StackCommandService;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StackCommandServiceImpl implements StackCommandService {

    private final StackTecRepository stackRepository;

    @Override
    @Transactional
    public StackTecnologia create(StackCreateRequest request) {
        if (stackRepository.existsByNome(request.getNome())) {
            throw new IllegalArgumentException("Stack com nome '" + request.getNome() + "' já existe");
        }

        StackTecnologia stack = StackTecnologia.builder()
                .nome(request.getNome())
                .categoria(request.getCategoria())
                .build();

        return stackRepository.save(stack);
    }

    @Override
    @Transactional
    public StackTecnologia update(Long id, StackUpdateRequest request) {
        StackTecnologia stack = stackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));

        if (request.getNome() != null && !request.getNome().equals(stack.getNome())) {
            if (stackRepository.existsByNome(request.getNome())) {
                throw new IllegalArgumentException("Stack com nome '" + request.getNome() + "' já existe");
            }
            stack.setNome(request.getNome());
        }

        if (request.getCategoria() != null) {
            stack.setCategoria(request.getCategoria());
        }

        return stackRepository.save(stack);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!stackRepository.existsById(id)) {
            throw new IllegalArgumentException("Stack não encontrada");
        }
        stackRepository.deleteById(id);
    }
}