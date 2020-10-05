package me.mafrans.gameoflife;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

public class Grid implements Cloneable {
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

    public Collection<Cell> getCells() {
        return this.cells.values();
    }

    @Override
    protected Object clone() {
        Grid clone = new Grid(width, height);
        clone.cells = (HashMap<Point, Cell>) cells.clone();
        return clone;
    }
}
