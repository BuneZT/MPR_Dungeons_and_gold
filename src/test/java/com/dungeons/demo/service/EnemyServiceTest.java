package com.dungeons.demo.service;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.repository.EnemyRepository;
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
public class EnemyServiceTest {

    @Mock
    private EnemyRepository enemyRepository;

    @InjectMocks
    private EnemyService enemyService;


    @Test
    void findAll() {
        when(enemyRepository.findAll()).thenReturn(List.of());

        List<Enemy> list = this.enemyService.findAll();

        assertThat(list.size()).isEqualTo(0);

    }

    @Test
    void findById() {
        when(enemyRepository.findById(2L)).thenReturn(Optional.of(new Enemy(25, 25, "test", 1, 2L, 2, 2)));

        Optional<Enemy> enemy = this.enemyService.findById(2L);

        assertThat(enemy.get().getId()).isEqualTo(2L);

    }

    @Test
    void deleteById() {
        enemyService.deleteById(1L);

        verify(enemyRepository, times(1)).deleteById(1L);
    }
}