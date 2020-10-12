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

        this.cells = new HashMap<Point, Cell>();
    }

    public void setCell(int x, int y, boolean isAlive) {
        if (isAlive) {
            this.cells.put(new Point(x, y), new Cell(x, y, this, isAlive));
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
        //for(Cell cell : getCells()) clone.setCell(cell.x, cell.y, cell.isAlive);
        return clone;
    }

    public void populateRandomly() {
        for (int ix = 0; ix < width; ix++) {
            for (int iy = 0; iy < height; iy++) {
                if(Math.random() < 0.5) {
                    this.setCell(ix, iy, true);
                }
            }
        }
    }
}
