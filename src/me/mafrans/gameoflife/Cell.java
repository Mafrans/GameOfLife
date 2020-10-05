package me.mafrans.gameoflife;

import java.awt.Point;
import java.util.Set;

public class Cell {
    public int x;
    public int y;
    public boolean isAlive;
    public Point[] neighbors;
    public Grid grid;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
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

    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }
}
