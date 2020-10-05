package me.mafrans.gameoflife;

import java.awt.*;
import java.util.HashMap;

public class Grid {
    private HashMap<Point, Cell> cells;
    public int width;
    public int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setCell(int x, int y, boolean isAlive) {
        if (isAlive) {
            this.cells.put(new Point(x, y), new Cell(x, y, isAlive));
        }
        else {
            this.cells.remove(new Point(x, y));
        }
    }

    public Cell getCell(int x, int y) {
        if (!this.cells.containsKey(new Point(x, y))) return null;
        return this.cells.get(new Point(x, y));
    }
}
