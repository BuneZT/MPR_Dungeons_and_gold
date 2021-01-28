package com.dungeons.demo.service;

import com.dungeons.demo.model.Item;
import com.dungeons.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;

    }

    public Item save(Item item) {
        return itemRepository.save(item);

    }

    public Item update(Item item) {
        if (itemRepository.findById(item.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return itemRepository.save(item);
        }

    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {

        return itemRepository.findById(id);
    }
}
