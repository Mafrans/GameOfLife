package me.mafrans.gameoflife;

import me.mafrans.gameoflife.rules.OverpopulationRule;
import me.mafrans.gameoflife.rules.ReproductionRule;
import me.mafrans.gameoflife.rules.Rule;
import me.mafrans.gameoflife.rules.UnderpopulationRule;

import java.awt.Point;

public class EvolutionManager {
    private GameOfLife gameOfLife;
    public Grid nextGrid;
    private Rule[] rules;

    public EvolutionManager(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.nextGrid = (Grid) gameOfLife.grid.clone();
        this.rules = new Rule[] { new OverpopulationRule(this), new UnderpopulationRule(this), new ReproductionRule(this) };
    }

    public void step() {
        Grid grid = this.gameOfLife.grid;
        this.nextGrid = (Grid) grid.clone();
        for(Cell cell : grid.getCells()) {
            if(cell.isAlive) {
                for(Rule rule : rules) {
                    rule.apply(cell);
                }

                for(Point p : cell.neighbors) {
                    Cell n = grid.getCell(p.x, p.y);
                    if(n == null) n = new Cell(p.x, p.y, grid, false);

                    rules[2].apply(n);
                }
            }
        }

        gameOfLife.grid = (Grid) nextGrid.clone();
    }
}
