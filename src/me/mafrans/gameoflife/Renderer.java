package me.mafrans.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer extends JPanel {
    private GameOfLife gameOfLife;
    private int width;
    private int height;
    private int scale;
    private BufferedImage image;

    public Renderer(GameOfLife gameOfLife, int scale) {
        this.gameOfLife = gameOfLife;
        this.scale = scale;
        this.width = gameOfLife.grid.width*scale;
        this.height = gameOfLife.grid.height*scale;
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
                if(cell.x * scale + ix >= width || cell.x * scale + ix < 0) continue;

                for (int iy = 0; iy < scale; iy++) {
                    if(cell.y * scale + iy >= height || cell.y * scale + iy < 0) continue;

                    this.image.setRGB(cell.x * scale + ix, cell.y * scale + iy, 0xFFFFFF);
                }
            }
        }

        this.validate();
        this.repaint();
        this.updateUI();
    }
}
