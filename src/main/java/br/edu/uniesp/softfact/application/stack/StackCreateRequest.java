package br.edu.uniesp.softfact.application.stack;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StackCreateRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Categoria é obrigatória")
    private String categoria;
}