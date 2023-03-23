package fr.npldev.tetris

abstract class Tetromino(open val shape: Array<Array<Int>>) {

    fun rotate(): Tetromino {
        val rotatedShape = Array(shape.size) { Array(shape.size) { 0 } }
        for (i in shape.indices) {
            for (j in shape.indices) {
                rotatedShape[i][j] = shape[j][shape.size - 1 - i]
            }
        }
        return createTetromino(rotatedShape)
    }

    abstract fun createTetromino(shape: Array<Array<Int>>): Tetromino
}

