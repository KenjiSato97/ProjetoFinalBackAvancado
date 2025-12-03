package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.StackCommandService;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stacks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StackCommandController {

    private final StackCommandService stackCommandService;

    @PostMapping
    public ResponseEntity<StackTecnologia> create(@Valid @RequestBody StackCreateRequest request) {
        try {
            StackTecnologia stack = stackCommandService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StackTecnologia> update(
            @PathVariable Long id,
            @Valid @RequestBody StackUpdateRequest request) {
        try {
            StackTecnologia stack = stackCommandService.update(id, request);
            return ResponseEntity.ok(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            stackCommandService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}