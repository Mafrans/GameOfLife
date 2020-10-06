package me.mafrans.gameoflife.rules;

import me.mafrans.gameoflife.Cell;
import me.mafrans.gameoflife.EvolutionManager;

import java.awt.*;

public class ReproductionRule extends Rule {
    public ReproductionRule(EvolutionManager evolutionManager) {
        super(evolutionManager);
    }

    @Override
    public void apply(Cell cell) {
        if (cell.isAlive) return; //Only apply rule on dead cells

        int count = 0;
        for(Point p : cell.neighbors) {
            Cell c = cell.grid.getCell(p.x, p.y);

            if(c.isAlive) count++;
        }

        if(count == 3) {
            evolutionManager.nextGrid.setCell(cell.x, cell.y, true);
        }
    }
}
