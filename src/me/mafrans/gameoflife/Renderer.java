package me.mafrans.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Renderer extends JPanel {
    private GameOfLife gameOfLife;
    private int width;
    private int height;
    private int scale;
    private BufferedImage image;

    public Renderer(GameOfLife gameOfLife, int width, int height, int scale) {
        this.gameOfLife = gameOfLife;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    @Override
    public void paint(Graphics g) {
        if(this.image == null) return;
        g.drawImage(this.image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void draw() {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(Cell cell : gameOfLife.grid.getCells()) {
            for (int ix = 0; ix < scale; ix++) {
                if(cell.x + ix > height) continue;

                for (int iy = 0; iy < scale; iy++) {
                    if(cell.y + iy > height) continue;

                    this.image.setRGB(cell.x + ix, cell.y + iy, 0xFFFFFF);
                }
            }
        }

        this.repaint();
        this.updateUI();
    }
}
