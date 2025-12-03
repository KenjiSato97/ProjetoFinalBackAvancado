package br.edu.uniesp.softfact.zo.old.stack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StackTecRepository extends JpaRepository<StackTecnologia, Long> {
    Optional<StackTecnologia> findByNome(String nome);

    List<StackTecnologia> findByCategoria(String categoria);

    boolean existsByNome(String nome);
}
