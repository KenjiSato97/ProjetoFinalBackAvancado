package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.domain.stack.StackQueryService;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stacks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StackQueryController {

    private final StackQueryService stackQueryService;

    @GetMapping
    public ResponseEntity<List<StackTecnologia>> findAll() {
        List<StackTecnologia> stacks = stackQueryService.findAll();
        return ResponseEntity.ok(stacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StackTecnologia> findById(@PathVariable Long id) {
        try {
            StackTecnologia stack = stackQueryService.findById(id);
            return ResponseEntity.ok(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<StackTecnologia> findByNome(@PathVariable String nome) {
        try {
            StackTecnologia stack = stackQueryService.findByNome(nome);
            return ResponseEntity.ok(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<StackTecnologia>> findByCategoria(@PathVariable String categoria) {
        List<StackTecnologia> stacks = stackQueryService.findByCategoria(categoria);
        return ResponseEntity.ok(stacks);
    }
}