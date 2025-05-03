package com.seaexplorer.SeaExplorer.model;

public class Grid {
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isWithinBounds(Position p) {
        return p.getX() >= 0 && p.getY() >= 0 && p.getX() < width && p.getY() < height;
    }
}