package com.abelrudy.orderfood.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import com.abelrudy.orderfood.model.Item;
import com.abelrudy.orderfood.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item findItemById(Long id){
        return itemRepository.getById(id);
    }

    public void deleteItemById(Long id){
        itemRepository.deleteById(id);
    }

    @Transactional
    public void updateItem(Long id, String name, String description, Double price, Long idCategory){
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalStateException(
            "No item matches with id " + id
        ));
        if(name != null && name.length() > 0 && Objects.equals(name, item.getName()))
            item.setName(name);
        if(description != null && description.length() > 0 && Objects.equals(description, item.getDescription()))
            item.setDescription(description);
        if(price != null && price > 0 && price != item.getPrice())
            item.setPrice(price);
        item.setCategory(categoryService.findCategory(idCategory));
    }
}
