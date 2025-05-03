package com.seaexplorer.SeaExplorer.service;

import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.service.impl.ProbeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeServiceImplTest {
    private ProbeServiceImpl probeService;

    @BeforeEach
    void setUp() {
        probeService = new ProbeServiceImpl();
    }

    @Test
    public void testExecuteCommand() {
        // Execute a simple command to move forward
        probeService.executeCommand("F");
        Position expectedPosition = new Position(0, 1); // After moving forward
        assertEquals(expectedPosition, probeService.getProbePosition());
    }
}
