package com.abelrudy.orderfood.controller;

import com.abelrudy.orderfood.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PutMapping(path = "/update/item/{id}")
    public void updateItem(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) Double price,
        @RequestParam(required = true) Long idCategory
    ){
        itemService.updateItem(id, name, description, price, idCategory);
    }

    @DeleteMapping(path = "/delete/item/{id}")
    public void deleteItem(@PathVariable("id") Long id){
        itemService.deleteItemById(id);
    }
}
