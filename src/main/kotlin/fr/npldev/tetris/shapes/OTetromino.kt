package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class OTetromino : Tetromino(
    arrayOf(
        arrayOf(1, 1),
        arrayOf(1, 1)
    ),
    Color.PINK
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return OTetromino()
    }
}