package com.seaexplorer.SeaExplorer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Probe.java
public class Probe {
    private Position position;
    private Direction direction;
    private final Grid grid;
    private final Set<Position> obstacles;
    private final List<Position> visited = new ArrayList<>();

    public Probe(Position position, Direction direction, Grid grid, Set<Position> obstacles) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.obstacles = obstacles;
        this.visited.add(position);
    }

    public void executeCommands(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'F') moveForward();
        }
    }

    private void moveForward() {
        Position next = switch (direction) {
            case N -> new Position(position.getX(), position.getY() + 1);
            case S -> new Position(position.getX(), position.getY() - 1);
            case E -> new Position(position.getX() + 1, position.getY());
            case W -> new Position(position.getX() - 1, position.getY());
        };
        if (grid.isWithinBounds(next) && !obstacles.contains(next)) {
            position = next;
            visited.add(position);
        }
    }

    public Position getPosition() {
        return position;
    }

    public List<Position> getVisited() {
        return visited;
    }
}
