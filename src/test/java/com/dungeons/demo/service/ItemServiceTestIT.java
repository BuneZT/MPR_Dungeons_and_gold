package com.dungeons.demo.service;

import com.dungeons.demo.model.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemServiceTestIT {

    @Autowired
    private ItemService itemService;

    @BeforeEach
    void cleanUp() {
        itemService.deleteAll();
    }

    @Test
    void shouldNotFindAnyone() {
        List<Item> all = itemService.findAll();
        Assertions.assertThat(all).isEmpty();
    }

    @Test
    void shouldFindAllItems() {
        itemService.save(new Item(25, 25, "test", 1, 2L, 25, List.of()));
        List<Item> all = itemService.findAll();
        Assertions.assertThat(all).isNotEmpty();
    }

    @Test
    void shouldSaveItem() {
        Item item = itemService.save(new Item(25, 25, "test", 1, 2L, 25, List.of()));
        Assertions.assertThat(item.getId()).isPositive();

    }

    @Test
    void shouldFindById() {
        Item item = itemService.save(new Item(25, 25, "test", 1, 2L, 25, List.of()));
        Assertions.assertThat(itemService.findById(item.getId())).isNotEmpty();

    }


}
