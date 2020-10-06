package me.mafrans.gameoflife

import javax.swing.JFrame

fun main() {
    // Do stuff here

    val gameOfLife = GameOfLife(100, 100);
    val renderer = Renderer(gameOfLife, 400, 400, 4);
    val frame = JFrame()
    frame.setTitle("Fint spel")
    frame.add(renderer)
    frame.pack()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    gameOfLife.grid.setCell(50, 50, true);
    gameOfLife.grid.setCell(49, 50, true);
    gameOfLife.grid.setCell(51, 50, true);
    gameOfLife.evolutionManager.step();
    renderer.draw();
}