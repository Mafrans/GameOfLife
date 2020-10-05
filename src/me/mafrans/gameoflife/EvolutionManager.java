package me.mafrans.gameoflife;

import me.mafrans.gameoflife.rules.OverpopulationRule;
import me.mafrans.gameoflife.rules.ReproductionRule;
import me.mafrans.gameoflife.rules.Rule;
import me.mafrans.gameoflife.rules.UnderpopulationRule;

public class EvolutionManager {
    private GameOfLife gameOfLife;
    private Rule[] rules;

    public EvolutionManager(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.rules = new Rule[] { new OverpopulationRule(), new UnderpopulationRule(), new ReproductionRule() };
    }

    public void step() {

    }
}
