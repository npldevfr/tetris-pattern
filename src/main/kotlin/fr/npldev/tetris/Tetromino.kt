package fr.npldev.tetris

import kotlin.random.Random

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

object TetrominoFactory {
    fun createRandomTetromino(): Tetromino {
        return when (Random.nextInt(0, 7)) {
            0 -> JTetromino()
            1 -> LTetromino()
            2 -> ITetromino()
            3 -> ZTetromino()
            4 -> STetromino()
            5 -> OTetromino()
            else -> TTetromino()
        }
    }
}

class ZTetromino : Tetromino(
    arrayOf(
        arrayOf(1, 1, 0),
        arrayOf(0, 1, 1),
        arrayOf(0, 0, 0)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return ZTetromino()
    }
}

class TTetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(1, 1, 1),
        arrayOf(0, 1, 0)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return TTetromino()
    }
}

class STetromino : Tetromino(
    arrayOf(
        arrayOf(0, 1, 1),
        arrayOf(1, 1, 0),
        arrayOf(0, 0, 0)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return STetromino()
    }
}

class OTetromino : Tetromino(
    arrayOf(
        arrayOf(1, 1),
        arrayOf(1, 1)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return OTetromino()
    }
}

class LTetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(1, 1, 1),
        arrayOf(1, 0, 0)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return LTetromino()
    }
}

