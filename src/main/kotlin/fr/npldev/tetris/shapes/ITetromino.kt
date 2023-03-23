package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class ITetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0, 0),
        arrayOf(1, 1, 1, 1),
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0)
    ),
    Color.CYAN
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return ITetromino()
    }
}