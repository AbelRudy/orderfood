package com.abelrudy.orderfood.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import com.abelrudy.orderfood.model.Category;
import com.abelrudy.orderfood.model.Item;
import com.abelrudy.orderfood.repository.CategoryRepository;
import com.abelrudy.orderfood.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Item> getItemsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "No category matches with id " + id));

        return category.getItems();
    }

    public List<Item> getItems() {
        List<Category> categories = getCategories();
        List<Item> items = new ArrayList<>();
        for (Category category : categories)
            items.addAll(getItemsByCategory(category.getId()));
        return items;
    }

    public Category findCategory(Long id) {
        return categoryRepository.getById(id);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void addItem(Long id, Item item) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "No category matches with id " + id));

        item.setCategory(category);
        System.out.println("Bien");
        itemRepository.save(item);
    }

    @Transactional
    public void updateCategory(Long id, String name) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "No category matches with id " + id));
        System.out.println(name + " %% " + category);
        if (name != null && name.length() > 0 && !Objects.equals(category.getName(), name))
            category.setName(name);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

}
