package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class STetromino : Tetromino(
    arrayOf(
        arrayOf(0, 1, 1),
        arrayOf(1, 1, 0),
        arrayOf(0, 0, 0)
    ),
    Color.GREEN
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return STetromino()
    }
}