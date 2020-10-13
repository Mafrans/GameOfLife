package me.mafrans.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        int rows = 300;
        int columns = 300;
        int scale = 4;

        GameOfLife gameOfLife = new GameOfLife(columns, rows);
        Renderer renderer = new Renderer(gameOfLife, scale);
        JFrame frame = new JFrame();

        frame.setTitle("Malte och Marcus Spel om Livet");
        frame.add(renderer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        Insets insets = frame.getInsets();
        frame.setSize(
                columns * scale + insets.left + insets.right,
                rows * scale + insets.top + insets.bottom
        );
        frame.setLocationRelativeTo(null);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameOfLife.evolutionManager.step();
                renderer.draw();
                Benchmarker.next("Render Time");
            }

            @Override public void keyReleased(KeyEvent e) { }
            @Override public void keyTyped(KeyEvent e) { }
        });

        gameOfLife.grid.populateRandomly();
        renderer.draw();
    }
}
