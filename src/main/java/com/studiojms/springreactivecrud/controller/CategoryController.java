package com.studiojms.springreactivecrud.controller;

import com.studiojms.springreactivecrud.model.Category;
import com.studiojms.springreactivecrud.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Flux<Category> index() {
        return categoryService.findAll();
    }

    @PostMapping
    public Mono<Category> create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Mono<Category> get(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

}
