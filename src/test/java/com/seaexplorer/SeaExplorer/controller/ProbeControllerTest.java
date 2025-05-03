package com.seaexplorer.SeaExplorer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ProbeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPosition() throws Exception {
        mockMvc.perform(get("/api/probe/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value(0))
                .andExpect(jsonPath("$.y").value(0));
    }

    @Test
    void testExecuteCommand() throws Exception {
        String command = "FFRFF";

        mockMvc.perform(post("/api/probe/command")
                        .contentType("application/json")
                        .content("\"" + command + "\""))
                .andExpect(status().isOk());

        // Verify that the position has changed after the command sequence
        mockMvc.perform(get("/api/probe/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value(2))
                .andExpect(jsonPath("$.y").value(2));
    }
}
