package me.mafrans.gameoflife

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

fun main() {
    // Do stuff here

    val gameOfLife = GameOfLife(800, 800);
    val renderer = Renderer(gameOfLife, 1600, 1600, 2);
    val frame = JFrame()
    frame.setTitle("Fint spel")
    frame.add(renderer)
    frame.pack()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    frame.addKeyListener(object : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            gameOfLife.evolutionManager.step();
            renderer.draw();
            Benchmarker.next("Render Time");
        }

        override fun keyReleased(e: KeyEvent?) {
        }

    })

    gameOfLife.grid.populateRandomly();
    renderer.draw();
}