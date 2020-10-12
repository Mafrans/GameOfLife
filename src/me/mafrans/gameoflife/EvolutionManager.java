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
        Benchmarker.next("Clone Time");
        for(Rule rule : rules) {
            for(Cell cell : grid.getCells()) {
                if(cell.isAlive) {
                    rule.apply(cell);
                }
            }
            Benchmarker.next(rule.getClass().getSimpleName());
        }
        Benchmarker.next("Rule Time");

        gameOfLife.grid = (Grid) nextGrid.clone();
        Benchmarker.next("Clone Time 2");
    }
}
