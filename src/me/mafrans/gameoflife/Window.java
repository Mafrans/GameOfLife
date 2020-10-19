package me.mafrans.gameoflife;

import javax.swing.*;
import java.awt.*;

public class Window {
    public final GameOfLife gameOfLife;
    public final Renderer renderer;

    public Window(int rows, int columns, int scale, String title) {

        this.gameOfLife = new GameOfLife(columns, rows);
        this.renderer = new Renderer(gameOfLife, scale);
        JFrame frame = new JFrame();

        frame.setTitle(title);
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

        gameOfLife.grid.populateRandomly();
        renderer.draw();

        frame.addKeyListener(new KeyboardListener(this));
    }
}
