package com.studiojms.springreactivecrud.service;

import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractCrudService<T, ID> {

    final private ReactiveCrudRepository repository;

    protected AbstractCrudService(ReactiveCrudRepository repository) {
        this.repository = repository;
    }

    public <S extends T> Mono<S> save(S objectToSave) {
        return repository.save(objectToSave);
    }

    public <S extends T> Flux<S> saveAll(Iterable<S> objectsToSave) {
        return repository.saveAll(objectsToSave);
    }

    public <S extends T> Flux<S> saveAll(Publisher<S> objectsToSave) {
        return repository.saveAll(objectsToSave);
    }

    public <S extends T> Mono<S> update(ID id, S objectToSave) {
        final Mono<Boolean> exists = existsById(id);

        return exists.flatMap(val -> {
            if (val) {
                return repository.save(objectToSave);
            } else {
                throw new IllegalArgumentException(String.format("Entity with id %s not found", id));
            }
        });
    }

    public Mono<T> findById(ID id) {
        return repository.findById(id);
    }

    public Mono<T> findById(Publisher<ID> publisher) {
        return repository.findById(publisher);
    }

    public Mono<Boolean> existsById(ID id) {
        return repository.existsById(id);
    }

    public Mono<Boolean> existsById(Publisher<ID> publisher) {
        return repository.existsById(publisher);
    }

    public Flux<T> findAll() {
        return repository.findAll();
    }

    public Flux<T> findAllById(Iterable<ID> iterable) {
        return repository.findAllById(iterable);
    }

    public Flux<T> findAllById(Publisher<ID> idPublisher) {
        return repository.findAllById(idPublisher);
    }

    public Mono<Long> count() {
        return repository.count();
    }

    public Mono<Void> deleteById(ID id) {
        return repository.deleteById(id);
    }

    public Mono<Void> deleteById(Publisher<ID> idPublisher) {
        return repository.deleteById(idPublisher);
    }

    public Mono<Void> delete(T objectToDelete) {
        return repository.delete(objectToDelete);
    }

    public Mono<Void> deleteAll(Iterable<? extends T> iterable) {
        return repository.deleteAll(iterable);
    }

    public Mono<Void> deleteAll(Publisher<? extends T> objectPublisher) {
        return repository.deleteAll(objectPublisher);
    }

    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }
}
