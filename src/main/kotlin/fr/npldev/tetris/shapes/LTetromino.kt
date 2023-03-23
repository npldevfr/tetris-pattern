package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class LTetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(1, 1, 1),
        arrayOf(1, 0, 0)
    ),
    Color.YELLOW
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return LTetromino()
    }
}