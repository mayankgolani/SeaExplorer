package com.seaexplorer.SeaExplorer.service;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Grid;
import com.seaexplorer.SeaExplorer.model.Position;
import com.seaexplorer.SeaExplorer.model.Probe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ProbeService {
    public void initializeProbe(int gridWidth, int gridHeight, int startX, int startY, String startDirection, List<Position> obstacleList);

    public void executeCommand(String commands);

    public Position getCurrentPosition();

    public Direction getCurrentDirection();

    public List<Position> getVisitedPositions();

    public boolean isInitialized();
}
