package com.dungeons.demo.service;

import com.dungeons.demo.model.Player;
import com.dungeons.demo.repository.PlayerRepository;
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
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;


    @Test
    void findAll() {
        when(playerRepository.findAll()).thenReturn(List.of());

        List<Player> list = this.playerService.findAll();

        assertThat(list.size()).isEqualTo(0);

    }

    @Test
    void findById() {
        when(playerRepository.findById(2L)).thenReturn(Optional.of(new Player(25, 25, "test", 1, 2L, 0, 25, List.of())));

        Optional<Player> player = this.playerService.findById(2L);

        assertThat(player.get().getId()).isEqualTo(2L);

    }

    @Test
    void deleteById() {
        playerService.deleteById(1L);

        verify(playerRepository, times(1)).deleteById(1L);
    }
}