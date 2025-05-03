package com.seaexplorer.SeaExplorer.probe;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {
    @Test
    void testMoveForwardFacingNorth() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(new Position(0, 0), Direction.N, grid, Set.of());
        probe.executeCommands("F");

        assertEquals(new Position(0, 1), probe.getPosition());
    }
}
