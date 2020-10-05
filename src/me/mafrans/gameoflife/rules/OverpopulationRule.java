package me.mafrans.gameoflife.rules;

import me.mafrans.gameoflife.Cell;
import me.mafrans.gameoflife.EvolutionManager;

public class OverpopulationRule extends Rule {
    public OverpopulationRule(EvolutionManager evolutionManager) {
        super(evolutionManager);
    }

    @Override
    public void apply(Cell cell) {
    }
}
