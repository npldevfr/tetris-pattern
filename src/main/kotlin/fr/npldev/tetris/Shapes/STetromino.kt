package fr.npldev.tetris.Shapes

import fr.npldev.tetris.Tetromino

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