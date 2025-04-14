package dgtic.core.maquetado.controller;

import dgtic.core.maquetado.service.GenericService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T, ID> {

    protected abstract GenericService<T, ID> getService();

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        return ResponseEntity.ok(getService().getById(id));
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody @Valid T entity) {
        return new ResponseEntity<>(getService().create(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody @Valid T entity) {
        return ResponseEntity.ok(getService().update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
