package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class TTetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(1, 1, 1),
        arrayOf(0, 1, 0)
    ),
    Color.PURPLE
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return TTetromino()
    }
}