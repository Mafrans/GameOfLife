package me.mafrans.gameoflife.rules;

import me.mafrans.gameoflife.Cell;
import me.mafrans.gameoflife.EvolutionManager;

import java.awt.*;

public class ReproductionRule extends Rule {
    public ReproductionRule(EvolutionManager evolutionManager) {
        super(evolutionManager);
    }

    private Cell originCell;

    @Override
    public void apply(Cell cell) {
        if (cell.isAlive) {
            for(Point p : cell.neighbors) {
                Cell n = cell.grid.getCell(p.x, p.y);
                Cell nextN = evolutionManager.nextGrid.getCell(p.x, p.y);

                if(nextN != null) continue; // ~35% performance increase
                if(n == null) n = new Cell(p.x, p.y, cell.grid, false);
                else if(n.isAlive) continue;

                originCell = cell;
                this.apply(n);
            }
            return;
        }


        int count = 1;
        for(Point p : cell.neighbors) {
            if(p.x == originCell.x && p.y == originCell.y) continue; // ~4% performance increase
            Cell c = cell.grid.getCell(p.x, p.y);

            if(c != null && c.isAlive) count++;
        }

        evolutionManager.nextGrid.setCell(cell.x, cell.y, count == 3);
    }
}
