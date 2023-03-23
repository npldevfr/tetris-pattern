package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino
import javafx.scene.paint.Color

class JTetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(1, 1, 1),
        arrayOf(0, 0, 1)
    ),
    Color.BLUE
) {
    override fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino {
        return JTetromino()
    }
}
