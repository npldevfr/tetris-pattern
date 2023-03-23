package fr.npldev.tetris.Shapes

import fr.npldev.tetris.Tetromino

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