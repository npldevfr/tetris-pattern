package fr.npldev.tetris

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage
import javafx.util.Duration

class TetrisApp : Application() {
    private val gameBoard = GameBoard.getInstance()
    private val timeline = Timeline()

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("main.fxml"))
        primaryStage.title = "Tetris"
        primaryStage.scene = Scene(root)
        primaryStage.show()

        primaryStage.scene.onKeyPressed = EventHandler<KeyEvent> { event ->
            when (event.code) {
                KeyCode.UP -> {
                    gameBoard.rotatePiece()
                    gameBoard.gameSubject.notifyObservers()
                }

                KeyCode.DOWN -> {
                    gameBoard.movePieceDown()
                    gameBoard.gameSubject.notifyObservers()
                }

                KeyCode.LEFT -> {
                    gameBoard.movePieceLeft()
                    gameBoard.gameSubject.notifyObservers()
                }

                KeyCode.RIGHT -> {
                    gameBoard.movePieceRight()
                    gameBoard.gameSubject.notifyObservers()
                }

                KeyCode.SPACE -> {
                    gameBoard.dropPiece()
                    gameBoard.gameSubject.notifyObservers()
                }

                else -> {}
            }
        }

        primaryStage.show()

        timeline.keyFrames.add(KeyFrame(Duration.millis(calculateInterval()), EventHandler {
            gameBoard.movePieceDown()
            gameBoard.gameSubject.notifyObservers()

        }))
        timeline.cycleCount = Timeline.INDEFINITE
        timeline.play()
    }

    private fun calculateInterval(): Double {
        return 1000.0
    }
}
