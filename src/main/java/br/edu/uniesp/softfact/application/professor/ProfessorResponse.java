package br.edu.uniesp.softfact.application.professor;

import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;

import java.util.Set;

public record ProfessorResponse(
        Integer idProfessor,
        String nome,
        String email
) {}

