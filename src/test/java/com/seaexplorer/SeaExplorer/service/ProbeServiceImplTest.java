package com.seaexplorer.SeaExplorer.service;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.service.impl.ProbeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProbeServiceImplTest {
    private ProbeServiceImpl probeService;

    @BeforeEach
    void setUp() {
        probeService = new ProbeServiceImpl();
    }

    @Test
    public void testInitializeProbe() {
        List<Position> obstacles = Arrays.asList(new Position(1, 1));
        probeService.initializeProbe(5, 5, 0, 0, "N", obstacles);

        assertTrue(probeService.isInitialized());
        assertEquals(new Position(0, 0), probeService.getCurrentPosition());
        assertEquals(Direction.N, probeService.getCurrentDirection());
    }

    @Test
    public void testExecuteCommandsWithObstacles() {
        List<Position> obstacles = Arrays.asList(new Position(0, 1));
        probeService.initializeProbe(5, 5, 0, 0, "N", obstacles);

        probeService.executeCommand("F");

        assertEquals(new Position(0, 0), probeService.getCurrentPosition());
        assertEquals(Arrays.asList(new Position(0, 0)), probeService.getVisitedPositions());
    }


}
