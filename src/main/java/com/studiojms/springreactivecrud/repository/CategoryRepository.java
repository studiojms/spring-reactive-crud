package com.studiojms.springreactivecrud.repository;

import com.studiojms.springreactivecrud.model.Category;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends R2dbcRepository<Category, Long> {
}
