package com.parionspotes.api.controller;

import com.parionspotes.api.model.Category;
import com.parionspotes.api.service.CategoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST) public @ResponseBody
    ResponseEntity<?> add(@RequestBody Category category) {
        Category createdCategory = categoryService.add(category);
        return ResponseEntity.ok(createdCategory);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(category);
    }

    @Transactional
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE) public @ResponseBody
    ResponseEntity<?> removeCategory(@PathVariable Long id) {
        Integer nbRemoved = categoryService.removeById(id);
        if (nbRemoved == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category with id: " + id);
        }
        return ResponseEntity.ok("Category with id " + id + " removed");
    }
}