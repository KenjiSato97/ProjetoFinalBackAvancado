package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.domain.stack.StackQueryService;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StackQueryServiceImpl implements StackQueryService {

    private final StackTecRepository stackRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StackTecnologia> findAll() {
        return stackRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public StackTecnologia findById(Long id) {
        return stackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public StackTecnologia findByNome(String nome) {
        return stackRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StackTecnologia> findByCategoria(String categoria) {
        return stackRepository.findByCategoria(categoria);
    }
}