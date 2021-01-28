package com.dungeons.demo.service;

import com.dungeons.demo.model.Item;
import com.dungeons.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

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
}
