package com.studiojms.springreactivecrud.service;

import com.studiojms.springreactivecrud.model.Category;
import com.studiojms.springreactivecrud.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractCrudService<Category, Long> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
