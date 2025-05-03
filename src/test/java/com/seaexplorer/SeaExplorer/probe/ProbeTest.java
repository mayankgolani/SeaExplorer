package com.seaexplorer.SeaExplorer.probe;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Grid;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.model.Probe;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {
    @Test
    public void testMoveForwardWithoutObstacles() {
        Grid grid = new Grid(5, 5, new HashSet<>());
        Probe probe = new Probe(new Position(0, 0), Direction.N, grid);

        probe.executeCommands("F");

        assertEquals(new Position(0, 1), probe.getPosition());
        assertEquals(Direction.N, probe.getDirection());
        assertEquals(Arrays.asList(new Position(0, 0), new Position(0, 1)), probe.getVisited());
    }

    @Test
    public void testObstaclePreventsMovement() {
        Set<Position> obstacles = new HashSet<>();
        obstacles.add(new Position(0, 1));
        Grid grid = new Grid(5, 5, obstacles);
        Probe probe = new Probe(new Position(0, 0), Direction.N, grid);

        probe.executeCommands("F");

        assertEquals(new Position(0, 0), probe.getPosition());
        assertEquals(Arrays.asList(new Position(0, 0)), probe.getVisited());
    }

    @Test
    public void testBoundaryPreventsMovement() {
        Grid grid = new Grid(5, 5, new HashSet<>());
        Probe probe = new Probe(new Position(0, 0), Direction.S, grid);

        probe.executeCommands("F");

        assertEquals(new Position(0, 0), probe.getPosition());
        assertEquals(Arrays.asList(new Position(0, 0)), probe.getVisited());
    }


}
