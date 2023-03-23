package fr.npldev.tetris.shapes

import fr.npldev.tetris.Tetromino

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