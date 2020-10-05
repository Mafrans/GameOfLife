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
        this.nextGrid = gameOfLife.grid.clone();
        this.rules = new Rule[] { new OverpopulationRule(), new UnderpopulationRule(), new ReproductionRule() };
    }

    public void step() {
        Grid grid = this.gameOfLife.grid;
        for(Cell cell : grid.getCells()) {
            if(cell.isAlive) {
                for(Rule rule : rules) {
                    rule.apply(cell);
                }

                for(Point p : cell.neighbors) {
                    gameOfLife.grid.setCell(p.x, p.y, false);
                    rules[2].apply(gameOfLife.grid.getCell(p.x, p.y));
                }
            }
        }
    }
}
