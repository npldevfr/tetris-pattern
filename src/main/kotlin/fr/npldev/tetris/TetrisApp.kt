package fr.npldev.tetris

import fr.npldev.tetris.controllers.WaitingToStartController
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
    private lateinit var primaryStage: Stage
    var state: TetrisState = WaitingToStartState()

    fun setPrimaryStage(stage: Stage) {
        primaryStage = stage
    }

    private fun showStartScreen() {
        val loader = FXMLLoader(javaClass.getResource("waiting-to-start.fxml"))
        val root = loader.load<Parent>()
        val controller = loader.getController<WaitingToStartController>()
        controller.setApp(this)

        primaryStage.title = "Tetris Arcade"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

    public fun showGameScreen() {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("main.fxml"))
        primaryStage.scene = Scene(root)
        primaryStage.show()
        state = PlayingState()

        primaryStage.scene.onKeyPressed = EventHandler<KeyEvent> { event ->
            state.handleKeyEvent(this, gameBoard, event)
            gameBoard.gameSubject.notifyObservers()
        }
    }

    fun startGame() {
        showGameScreen()
    }

    fun quit() {
        primaryStage.close()
    }

    override fun start(primaryStage: Stage) {

        setPrimaryStage(primaryStage)
        showStartScreen()

        primaryStage.show()

        timeline.keyFrames.add(KeyFrame(Duration.millis(gameBoard.getInterval()), EventHandler {
            state.update(this, gameBoard)
            gameBoard.gameSubject.notifyObservers()
            if (state is PlayingState) {
                gameBoard.timer++
            }
        }))
        timeline.cycleCount = Timeline.INDEFINITE
        timeline.play()
    }

}

class PlayingState : TetrisState {
    override fun handleKeyEvent(tetrisApp: TetrisApp, gameBoard: GameBoard, event: KeyEvent) {
        // gère les entrées clavier pour déplacer la piece
        when (event.code) {
            KeyCode.UP -> gameBoard.rotatePiece()
            KeyCode.DOWN -> gameBoard.movePieceDown()
            KeyCode.LEFT -> gameBoard.movePieceLeft()
            KeyCode.RIGHT -> gameBoard.movePieceRight()
            KeyCode.SPACE -> gameBoard.dropPiece()
            KeyCode.P -> tetrisApp.state = PausedState() // Pause le jeu en appuyant sur 'P'
            else -> {}
        }
    }

    override fun update(tetrisApp: TetrisApp, gameBoard: GameBoard) {
        gameBoard.tryGoDown()
    }
}

class WaitingToStartState : TetrisState {
    override fun handleKeyEvent(tetrisApp: TetrisApp, gameBoard: GameBoard, event: KeyEvent) {
        if (event.code == KeyCode.ENTER) {
            tetrisApp.showGameScreen() // Charge la vue main en appuyant sur 'ENTER'
            tetrisApp.state = PlayingState() // Commence le jeu en appuyant sur 'ENTER'
        }
    }

    override fun update(tetrisApp: TetrisApp, gameBoard: GameBoard) {
        // Aucune mise à jour nécessaire en attendant de démarrer
    }
}


class PausedState : TetrisState {
    override fun handleKeyEvent(tetrisApp: TetrisApp, gameBoard: GameBoard, event: KeyEvent) {
        if (event.code == KeyCode.P) {
            tetrisApp.state = PlayingState()
        }
    }

    override fun update(tetrisApp: TetrisApp, gameBoard: GameBoard) {
        // Aucune mise à jour nécessaire en pause
    }
}