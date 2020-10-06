package me.mafrans.gameoflife

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

fun main() {
    // Do stuff here

    val gameOfLife = GameOfLife(100, 100);
    val renderer = Renderer(gameOfLife, 1300, 1300, 13);
    val frame = JFrame()
    frame.setTitle("Fint spel")
    frame.add(renderer)
    frame.pack()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    frame.addKeyListener(object : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
            TODO("Not yet implemented")
        }

        override fun keyPressed(e: KeyEvent?) {
            gameOfLife.evolutionManager.step();
            renderer.draw();
        }

        override fun keyReleased(e: KeyEvent?) {
            TODO("Not yet implemented")
        }

    })

    gameOfLife.grid.setCell(50, 50, true);
    gameOfLife.grid.setCell(49, 50, true);
    gameOfLife.grid.setCell(51, 50, true);
    println(gameOfLife.grid.cells);
    renderer.draw();
}