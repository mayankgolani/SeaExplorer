package com.seaexplorer.SeaExplorer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Probe {
    private Position position;
    private Direction direction;
    private final Grid grid;
    private final List<Position> visited;

    public Probe(Position startPosition, Direction startDirection, Grid grid) {
        this.position = startPosition;
        this.direction = startDirection;
        this.grid = grid;
        this.visited = new ArrayList<>();
        this.visited.add(startPosition);
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'F':
                    move(1);
                    break;
                case 'B':
                    move(-1);
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                default:
                    // Handle invalid command if necessary
                    break;
            }
        }
    }

    private void move(int step) {
        Position nextPosition = calculateNextPosition(step);
        if (grid.isWithinBounds(nextPosition) && !grid.isObstacle(nextPosition)) {
            position = nextPosition;
            visited.add(position);
        }
        // Else, ignore the move due to boundary or obstacle
    }

    private Position calculateNextPosition(int step) {
        int x = position.getX();
        int y = position.getY();
        switch (direction) {
            case N:
                y += step;
                break;
            case S:
                y -= step;
                break;
            case E:
                x += step;
                break;
            case W:
                x -= step;
                break;
        }
        return new Position(x, y);
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getVisited() {
        return visited;
    }
}

