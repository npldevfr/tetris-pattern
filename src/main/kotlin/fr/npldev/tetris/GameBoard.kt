package fr.npldev.tetris

class GameBoard private constructor() {
    public val gameSubject = GameSubject()

    companion object {
        const val WIDTH = 10
        const val HEIGHT = 20

        @Volatile
        private var INSTANCE: GameBoard? = null

        fun getInstance(): GameBoard {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: GameBoard().also { INSTANCE = it }
            }
        }
    }

    private val board: Array<Array<Int>> = Array(HEIGHT) { Array(WIDTH) { 0 } }
    var currentPiece: Tetromino = randomTetromino()
    var piecePosition: Position = Position(WIDTH / 2 - 2, 0)

    private var score = 0
    private var level = 1
    private var lines = 0

    fun movePieceLeft() {
        if (isValidMove(piecePosition.x - 1, piecePosition.y)) {
            piecePosition = piecePosition.copy(x = piecePosition.x - 1)
        }
    }

    fun movePieceRight() {
        if (isValidMove(piecePosition.x + 1, piecePosition.y)) {
            piecePosition = piecePosition.copy(x = piecePosition.x + 1)
        }
    }

    fun movePieceDown(): Boolean {
        return if (isValidMove(piecePosition.x, piecePosition.y + 1)) {
            piecePosition = piecePosition.copy(y = piecePosition.y + 1)
            true
        } else {
            placePiece()
            clearFullLines()
            spawnNewPiece()
            !isGameOver()

        }
    }

    private fun isValidMove(x: Int, y: Int, shape: Array<Array<Int>> = currentPiece.shape): Boolean {
        for (i in shape.indices) {
            for (j in shape[i].indices) {
                if (shape[i][j] != 0) {
                    if (y + i >= HEIGHT || x + j < 0 || x + j >= WIDTH) {
                        return false
                    }
                    if (board[y + i][x + j] != 0) {
                        return false
                    }
                }
            }
        }
        return true
    }

    fun placePiece() {
        for (i in currentPiece.shape.indices) {
            for (j in currentPiece.shape[i].indices) {
                if (currentPiece.shape[i][j] != 0) {
                    board[piecePosition.y + i][piecePosition.x + j] = currentPiece.shape[i][j]
                }
            }
        }
    }

    public fun getBoard(): Array<Array<Int>> {
        return board
    }

    public fun dropPiece() {
       print("drop")
    }

    private fun clearFullLines() {
        var linesCleared = 0
        for (y in board.indices.reversed()) {
            if (board[y].all { cell -> cell != 0 }) {
                // Remove the full line
                board[y].fill(0)

                // Shift all lines above the cleared line down
                for (shiftY in y downTo 1) {
                    board[shiftY].forEachIndexed { index, _ ->
                        board[shiftY][index] = board[shiftY - 1][index]
                    }
                }
                // Clear the top line
                board[0].fill(0)

                // Increment the linesCleared counter
                linesCleared++
            }
        }

        // Update the lines counter, score, and level
        lines += linesCleared
        score += linesCleared * 100 * level
        level = 1 + lines / 10
    }

    private fun spawnNewPiece() {
        currentPiece = randomTetromino()
        piecePosition = Position(WIDTH / 2 - 2, 0)
    }

    private fun isGameOver(): Boolean {
        return false
    }

    private fun randomTetromino(): Tetromino {
        return TetrominoFactory.createRandomTetromino()
    }

    fun getCell(x: Int, y: Int): Int {
        return board[y][x]
    }

    fun rotatePiece() {
        val rotatedShape = currentPiece.rotate()
        if (isValidMove(piecePosition.x, piecePosition.y, rotatedShape.shape)) {
            currentPiece = rotatedShape
        }
    }

}

