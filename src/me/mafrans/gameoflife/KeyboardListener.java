package me.mafrans.gameoflife;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Window window;

    public KeyboardListener(Window window) {
        this.window = window;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        window.gameOfLife.evolutionManager.step();
        window.renderer.draw();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
