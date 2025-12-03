package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;
import br.edu.uniesp.softfact.application.projeto.ProjetoUpdateRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.ProjetoCommandService;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoCommandServiceImpl implements ProjetoCommandService {

    private final ProjetoRepository repository;

    @Override
    public Projeto save(Projeto projeto) {
        var entity = ProjetoEntityMapper.toEntity(projeto);
        return ProjetoEntityMapper.toDomain(repository.save(entity));
    }

    @Override
    public Projeto update(Projeto projeto) {
       var entity = ProjetoEntityMapper.toEntity(projeto);
        return ProjetoEntityMapper.toDomain(repository.save(entity));
    }
}
