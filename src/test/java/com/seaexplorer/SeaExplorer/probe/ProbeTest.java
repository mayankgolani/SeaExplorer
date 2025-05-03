package com.seaexplorer.SeaExplorer.probe;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Grid;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.model.Probe;
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

    @Test
    void testTurning() {
        Direction dir = Direction.N;
        assertEquals(Direction.W, dir.turnLeft());
        assertEquals(Direction.E, dir.turnRight());
    }
}
