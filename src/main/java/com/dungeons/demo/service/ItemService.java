package com.dungeons.demo.service;

import com.dungeons.demo.model.Item;
import com.dungeons.demo.model.Player;
import com.dungeons.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    private PlayerService playerService;


    public ItemService(ItemRepository itemRepository, PlayerService playerService) {
        this.itemRepository = itemRepository;
        this.playerService = playerService;


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

    public void sell(Long itemId, Long playerId) {
        Optional<Player> player = playerService.findById(playerId);

        if (player.isEmpty()) {
            throw new RuntimeException();
        }

        Optional<Item> item = this.findById(itemId);

        if (item.isEmpty()) {
            throw new RuntimeException();
        }

        if (player.get().getGold() - item.get().getCost() < 0) {
            throw new RuntimeException();
        }


        this.processSell(item.get(), player.get());
    }

    private void processSell(Item item, Player player) {
        player.setGold(player.getGold() - item.getCost());
        player.getItemList().add(item);
        this.playerService.update(player);

    }
}
