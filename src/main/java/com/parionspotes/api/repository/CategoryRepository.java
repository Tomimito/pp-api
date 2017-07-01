package com.parionspotes.api.repository;

import com.parionspotes.api.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Category findOneById(Long id);
    Integer removeById(Long id);
}