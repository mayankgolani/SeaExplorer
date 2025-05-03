package com.seaexplorer.SeaExplorer.model.DTO;

import com.seaexplorer.SeaExplorer.model.Position;

import java.util.List;

public class InitRequest {
    private int gridWidth;
    private int gridHeight;
    private int startX;
    private int startY;
    private String startDirection;
    private List<Position> obstacles;

    public InitRequest(int gridWidth, int gridHeight, int startX, int startY, String startDirection, List<Position> obstacles) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.startX = startX;
        this.startY = startY;
        this.startDirection = startDirection;
        this.obstacles = obstacles;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public String getStartDirection() {
        return startDirection;
    }

    public void setStartDirection(String startDirection) {
        this.startDirection = startDirection;
    }

    public List<Position> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Position> obstacles) {
        this.obstacles = obstacles;
    }
}
