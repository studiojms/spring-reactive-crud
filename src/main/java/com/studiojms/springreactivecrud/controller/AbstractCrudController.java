package com.studiojms.springreactivecrud.controller;

import com.studiojms.springreactivecrud.service.AbstractCrudService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractCrudController<T, ID> {

    private final AbstractCrudService<T, ID> service;

    protected AbstractCrudController(AbstractCrudService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public Flux<T> index() {
        return service.findAll();
    }

    @PostMapping
    public Mono<T> create(@RequestBody T clazz) {
        return service.save(clazz);
    }

    @PutMapping("/{id}")
    public Mono<T> update(@PathVariable("id") ID id, @RequestBody T clazz) {
        return service.update(id, clazz);
    }

    @GetMapping("/{id}")
    public Mono<T> get(@PathVariable("id") ID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") ID id) {
        return service.deleteById(id);
    }


}
