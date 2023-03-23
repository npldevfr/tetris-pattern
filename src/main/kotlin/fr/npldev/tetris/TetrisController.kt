package fr.npldev.tetris

import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color

class TetrisController : GameObserver {
    lateinit var levelLabel: Label
    lateinit var scoreLabel: Label
    lateinit var scorePane: GridPane
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

        scoreLabel.text = gameBoard.getScore().toString()
        levelLabel.text = gameBoard.getLevel().toString()


        // show board
        for (i in 0 until GameBoard.HEIGHT) {
            for (j in 0 until GameBoard.WIDTH) {
                if (gameBoard.getBoard()[i][j] != 0) {
                    gc.fill = Color.BLACK
                    gc.fillRect(j * cellSize, i * cellSize, cellSize, cellSize)
                }
            }
        }

        // show current piece
        val piece = gameBoard.currentPiece
        val position = gameBoard.piecePosition

        for (i in piece.shape.indices) {
            for (j in piece.shape[i].indices) {
                if (piece.shape[i][j] != 0) {
                    gc.fill = piece.color
                    gc.fillRect((j + position.x) * cellSize, (i + position.y) * cellSize, cellSize, cellSize)
                }
            }
        }

    }
}

private operator fun <T> Array<T>.get(b: Boolean): T {
    return if (b) this[1] else this[0]
}
