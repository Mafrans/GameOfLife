package me.mafrans.gameoflife;

public class GameOfLife {
    public Grid grid;
    public EvolutionManager evolutionManager;

    public GameOfLife(int width, int height) {
        this.grid = new Grid(width, height);
    }
}
