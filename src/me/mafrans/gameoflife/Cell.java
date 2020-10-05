package me.mafrans.gameoflife;

import java.util.Set;

public class Cell {
    public int x;
    public int y;
    public boolean isAlive;
    public Set<Cell> neighbors;
    public Grid grid;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }
}
