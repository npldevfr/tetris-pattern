package fr.npldev.tetris.Shapes

import fr.npldev.tetris.Tetromino

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