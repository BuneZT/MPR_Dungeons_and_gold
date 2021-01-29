package com.dungeons.demo.controller;

import com.dungeons.demo.model.Item;
import com.dungeons.demo.service.ItemService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemService itemService;

    @Test
    void shouldReturnEmptyList() throws Exception {
        mockMvc.perform(get("/item/list")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    void shouldReturnItem() throws Exception {
        Item item = itemService.save(new Item(25, 25, "test", 1, 2L, 25, List.of()));
        mockMvc.perform(get("/item/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(CoreMatchers.equalTo("{\"id\":1,\"health\":25,\"attack\":25,\"name\":\"test\",\"level\":1,\"cost\":25}")));


    }
}
