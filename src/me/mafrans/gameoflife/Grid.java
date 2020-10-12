package me.mafrans.gameoflife;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Grid implements Cloneable {
    public int width;
    public int height;
    private HashMap<Point, Cell> cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        this.cells = new HashMap<Point, Cell>();
    }

    public void setCell(int x, int y, boolean isAlive) {
        this.cells.put(new Point(x, y), new Cell(x, y, this, isAlive));
    }

    public Cell getCell(int x, int y) {
        Point point = new Point(x, y);
        if (!this.cells.containsKey(point)) return null;
        return this.cells.get(point);
    }

    public void removeCell(int x, int y) {
        cells.remove(new Point(x, y));
    }

    public Collection<Cell> getCells() {
        return this.cells.values();
    }

    @Override
    protected Object clone() {
        Grid clone = new Grid(width, height);
        //clone.cells = (HashMap<Point, Cell>) cells.clone();
        for(Cell cell : getCells()) clone.setCell(cell.x, cell.y, cell.isAlive);
        return clone;
    }

    public void populateRandomly() {
        for (int ix = 0; ix < width; ix++) {
            for (int iy = 0; iy < height; iy++) {
                if (Math.random() < 0.5) {
                    this.setCell(ix, iy, true);
                }
            }
        }
    }

    public void removeDead() {
        cells = (HashMap<Point, Cell>) cells.entrySet()
                .stream()
                .filter(map -> map.getValue().isAlive)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }
}
