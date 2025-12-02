package br.edu.uniesp.softfact.infra.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    boolean existsByEmail(String email);

    Optional<ProfessorEntity> findByEmail(String email);

    // Busca por nome (equivalente ao de Aluno)
    Page<ProfessorEntity> findByNomeContainingIgnoreCase(String nome, Pageable pageable);


}
