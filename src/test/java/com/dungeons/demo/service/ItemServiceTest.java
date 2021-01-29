package com.dungeons.demo.service;

import com.dungeons.demo.model.Item;
import com.dungeons.demo.repository.ItemRepository;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;


    @Test
    void findAll() {
        when(itemRepository.findAll()).thenReturn(List.of());

        List<Item> list = this.itemService.findAll();

        assertThat(list.size()).isEqualTo(0);

    }

    @Test
    void findById() {
        when(itemRepository.findById(2L)).thenReturn(Optional.of(new Item(25, 25, "test", 1, 2L, 25, List.of())));

        Optional<Item> item = this.itemService.findById(2L);

        assertThat(item.get().getId()).isEqualTo(2L);

    }

    @Test
    void deleteById() {
        itemService.deleteById(1L);

        verify(itemRepository, times(1)).deleteById(1L);
    }
}