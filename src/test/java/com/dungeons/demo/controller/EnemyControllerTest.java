package com.dungeons.demo.controller;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.service.EnemyService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EnemyControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EnemyService enemyService;

    @Test
    void shouldReturnEmptyList() throws Exception {
        mockMvc.perform(get("/enemy/list")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    void shouldReturnEnemy() throws Exception {
        Enemy enemy = enemyService.save(new Enemy(25, 25, "test", 1, 2L, 2, 2));
        mockMvc.perform(get("/enemy/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(CoreMatchers.equalTo("{\"id\":1,\"health\":25,\"attack\":25,\"name\":\"test\",\"level\":1,\"rewardGold\":2,\"rewardExp\":2}")));


    }
}
