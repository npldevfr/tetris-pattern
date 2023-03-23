package fr.npldev.tetris

import javafx.scene.paint.Color

abstract class Tetromino(open var shape: Array<Array<Int>>, open val color: Color) {

    fun rotate(): Array<Array<Int>> {
        val rotated = Array(shape.size) { Array(shape.size) { 0 } }
        for (i in shape.indices) {
            for (j in shape.indices) {
                rotated[i][j] = shape[shape.size - 1 - j][i]
            }
        }
        return rotated
    }

    abstract fun createTetromino(shape: Array<Array<Int>>, color: Color): Tetromino
}

