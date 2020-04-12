package com.studiojms.springreactivecrud.controller;

import com.studiojms.springreactivecrud.model.Category;
import com.studiojms.springreactivecrud.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController extends AbstractCrudController<Category, Long> {

    protected CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
