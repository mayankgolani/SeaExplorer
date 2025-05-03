package com.seaexplorer.SeaExplorer.service;

import com.seaexplorer.SeaExplorer.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeServiceTest {
    private ProbeService probeService;

    @BeforeEach
    void setUp() {
        probeService = new ProbeService();
    }

    @Test
    public void testExecuteCommand() {
        // Execute a simple command to move forward
        probeService.executeCommand("F");
        Position expectedPosition = new Position(0, 1); // After moving forward
        assertEquals(expectedPosition, probeService.getProbePosition());
    }
}
