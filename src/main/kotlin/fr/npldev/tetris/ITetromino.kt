package fr.npldev.tetris

class ITetromino : Tetromino(
    arrayOf(
        arrayOf(0, 0, 0, 0),
        arrayOf(1, 1, 1, 1),
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0)
    )
) {
    override fun createTetromino(shape: Array<Array<Int>>): Tetromino {
        return ITetromino()
    }
}