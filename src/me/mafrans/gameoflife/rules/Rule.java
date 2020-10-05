package me.mafrans.gameoflife.rules;

import me.mafrans.gameoflife.Cell;

public interface Rule {
    public void apply(Cell cell);
}
