package me.mafrans.gameoflife.rules;

import me.mafrans.gameoflife.Cell;
import me.mafrans.gameoflife.EvolutionManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Rule {
    public EvolutionManager evolutionManager;

    public Rule(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager;
    }

    public void apply(Cell cell) {
        throw new NotImplementedException();
    };
}
