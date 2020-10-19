package me.mafrans.gameoflife;

import me.mafrans.gameoflife.rules.OverpopulationRule;
import me.mafrans.gameoflife.rules.ReproductionRule;
import me.mafrans.gameoflife.rules.Rule;
import me.mafrans.gameoflife.rules.UnderpopulationRule;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

        for(Rule rule : this.rules) {
            for(Cell cell : grid.getCells()) {
                if(cell.isAlive) {
                    rule.apply(cell);
                }
            }
        }

        this.nextGrid.removeDead();
        this.gameOfLife.grid = (Grid) this.nextGrid.clone();
    }
}
