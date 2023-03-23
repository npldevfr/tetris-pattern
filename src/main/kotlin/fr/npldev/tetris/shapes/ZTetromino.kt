package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class ZTetromino : Tetromino(
    arrayOf(
        arrayOf(1, 1, 0),
        arrayOf(0, 1, 1),
        arrayOf(0, 0, 0)
    ),
    Color.RED
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return ZTetromino()
    }
}