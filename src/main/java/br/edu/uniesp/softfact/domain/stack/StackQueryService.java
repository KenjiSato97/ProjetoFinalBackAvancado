package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;

import java.util.List;

public interface StackQueryService {
    List<StackTecnologia> findAll();
    StackTecnologia findById(Long id);
    StackTecnologia findByNome(String nome);
    List<StackTecnologia> findByCategoria(String categoria);
}