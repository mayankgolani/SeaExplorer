package com.seaexplorer.SeaExplorer.service.impl;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Grid;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.model.Probe;
import com.seaexplorer.SeaExplorer.service.ProbeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProbeServiceImpl implements ProbeService {

    private Probe probe;

    public void initializeProbe(int gridWidth, int gridHeight, int startX, int startY, String startDirection, List<Position> obstacleList) {
        Set<Position> obstacles = new HashSet<>(obstacleList);
        Grid grid = new Grid(gridWidth, gridHeight, obstacles);
        Position startPosition = new Position(startX, startY);
        Direction direction = Direction.valueOf(startDirection);
        this.probe = new Probe(startPosition, direction, grid);
    }

    public void executeCommand(String commands) {
        if (probe != null) {
            probe.executeCommands(commands);
        }
    }

    public Position getCurrentPosition() {
        return probe.getPosition();
    }

    public Direction getCurrentDirection() {
        return probe.getDirection();
    }

    public List<Position> getVisitedPositions() {
        return probe.getVisited();
    }

    public boolean isInitialized() {
        return probe != null;
    }
}