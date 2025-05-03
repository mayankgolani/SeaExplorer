package com.seaexplorer.SeaExplorer.controller;

import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.service.ProbeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProbeController.class)
public class ProbeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProbeService probeService;

    @BeforeEach
    void setUp() {
        probeService = mock(ProbeService.class);
    }

    @Test
    public void testGetPosition() throws Exception {
        when(probeService.getProbePosition()).thenReturn(new Position(0, 1));
        mockMvc.perform(get("/api/probe/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value(0))
                .andExpect(jsonPath("$.y").value(1));
    }

    @Test
    public void testExecuteCommand() throws Exception {
        mockMvc.perform(post("/api/probe/execute")
                        .param("command", "F"))
                .andExpect(status().isOk());
    }
}
