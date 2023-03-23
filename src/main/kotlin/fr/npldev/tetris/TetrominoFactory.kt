package fr.npldev.tetris

import fr.npldev.tetris.shapes.*
import kotlin.random.Random

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