package me.mafrans.gameoflife

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

fun main() {
    val rows = 100
    val columns = 100
    val scale = 8

    val gameOfLife = GameOfLife(columns, rows)
    val renderer = Renderer(gameOfLife, scale)
    val frame = JFrame()

    frame.setTitle("Fint spel")
    frame.add(renderer)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setResizable(false)
    frame.setVisible(true)
    val insets = frame.insets;
    frame.setSize(
            columns * scale + insets.left + insets.right,
            rows * scale + insets.top + insets.bottom
    )
    frame.setLocationRelativeTo(null)

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