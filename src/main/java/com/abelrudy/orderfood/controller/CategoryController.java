package com.abelrudy.orderfood.controller;

import java.util.List;

import com.abelrudy.orderfood.model.Category;
import com.abelrudy.orderfood.model.Item;
import com.abelrudy.orderfood.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(path = "/items/all")
    public List<Item> getItems() {
        return categoryService.getItems();
    }

    @GetMapping(path = "/items/{id}")
    public List<Item> getItemsByCategory(@PathVariable("id") Long id) {
        return categoryService.getItemsByCategory(id);
    }

    @GetMapping(path = "/category/{id}")
    public Category findCategory(@PathVariable("id") Long id) {
        return categoryService.findCategory(id);
    }

    @PostMapping(path = "/add/categories")
    public void addCategory(@RequestBody(required = true) Category... categories) {
        for (Category category : categories)
            categoryService.addCategory(category);
    }

    @PostMapping(path = "/add/items/{id}")
    public void addItem(@PathVariable("id") Long id, @RequestBody(required = true) Item... items) {
        for (Item item : items)
            categoryService.addItem(id, item);
    }

    @PutMapping(path = "/update/category/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestParam(required = false) String name) {
        categoryService.updateCategory(id, name);
    }

    @DeleteMapping(path = "/delete/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }
}
