package me.mafrans.gameoflife;

import java.awt.Point;
import java.util.Arrays;
import java.util.Set;

public class Cell {
    public int x;
    public int y;
    public boolean isAlive;
    public Point[] neighbors;
    public Grid grid;

    public Cell(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.neighbors = new Point[]{
                new Point(x + 1, y),
                new Point(x + 1, y + 1),
                new Point(x, y + 1),
                new Point(x - 1, y + 1),
                new Point(x - 1, y),
                new Point(x - 1, y - 1),
                new Point(x, y - 1),
                new Point(x + 1, y - 1)
        };
    }

    public Cell(int x, int y, Grid grid, boolean isAlive) {
        this(x, y, grid);
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", isAlive=" + isAlive +
                ", neighbors=" + Arrays.toString(neighbors) +
                ", grid=" + grid +
                '}';
    }
}
