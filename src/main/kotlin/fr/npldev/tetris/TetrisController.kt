package fr.npldev.tetris

import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class TetrisController : GameObserver {
    private val gameBoard = GameBoard.getInstance()

    @FXML
    lateinit var gameCanvas: Canvas

    private val cellSize = 20.0

    init {
        gameBoard.gameSubject.addObserver(this)
    }

    override fun update() {
        drawGame()
    }

    private fun drawGame() {

        val gc: GraphicsContext = gameCanvas.graphicsContext2D
        gc.clearRect(0.0, 0.0, gameCanvas.width, gameCanvas.height)

        for (y in 0 until GameBoard.HEIGHT) {
            for (x in 0 until GameBoard.WIDTH) {
                val cell = gameBoard.getCell(x, y)
                gc.fill = if (cell == 0) Color.WHITE else Color.BLACK
                gc.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)
            }
        }

        val piece = gameBoard.currentPiece
        val position = gameBoard.piecePosition

        for (y in 0 until piece.shape.size) {
            for (x in 0 until piece.shape[y].size) {
                if (piece.shape[y][x] != 0) {
                    gc.fill = piece.color;
                    gc.fillRect((position.x + x) * cellSize, (position.y + y) * cellSize, cellSize, cellSize)
                }
            }
        }
    }
}

private operator fun <T> Array<T>.get(b: Boolean): T {
    return if (b) this[1] else this[0]
}
