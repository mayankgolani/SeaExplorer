package com.seaexplorer.SeaExplorer.model.DTO;

import com.seaexplorer.SeaExplorer.model.Direction;
import com.seaexplorer.SeaExplorer.model.Position;

import java.util.List;

public class ProbeStatus {
    private Position currentPosition;
    private Direction currentDirection;
    private List<Position> visitedPositions;

    public ProbeStatus() {
    }

    public ProbeStatus(Position currentPosition, Direction currentDirection, List<Position> visitedPositions) {
        this.currentPosition = currentPosition;
        this.currentDirection = currentDirection;
        this.visitedPositions = visitedPositions;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public List<Position> getVisitedPositions() {
        return visitedPositions;
    }

    public void setVisitedPositions(List<Position> visitedPositions) {
        this.visitedPositions = visitedPositions;
    }
}
