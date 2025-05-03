package com.seaexplorer.SeaExplorer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
    public void testInitEndpoint() throws Exception {
        String initJson = "{ \"gridWidth\": 5, \"gridHeight\": 5, \"startX\": 0, \"startY\": 0, \"startDirection\": \"N\", \"obstacles\": [{\"x\":1,\"y\":1}] }";

        mockMvc.perform(post("/api/probe/init")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(initJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testCommandsEndpoint() throws Exception {
        String initJson = "{ \"gridWidth\": 5, \"gridHeight\": 5, \"startX\": 0, \"startY\": 0, \"startDirection\": \"N\", \"obstacles\": [] }";
        mockMvc.perform(post("/api/probe/init")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(initJson))
                .andExpect(status().isOk());

        String commandJson = "{ \"commands\": \"FFRFF\" }";
        mockMvc.perform(post("/api/probe/commands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(commandJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testStatusEndpoint() throws Exception {
        String initJson = "{ \"gridWidth\": 5, \"gridHeight\": 5, \"startX\": 0, \"startY\": 0, \"startDirection\": \"N\", \"obstacles\": [] }";
        mockMvc.perform(post("/api/probe/init")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(initJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/probe/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPosition.x").value(0))
                .andExpect(jsonPath("$.currentPosition.y").value(0))
                .andExpect(jsonPath("$.currentDirection").value("N"));
    }


}
