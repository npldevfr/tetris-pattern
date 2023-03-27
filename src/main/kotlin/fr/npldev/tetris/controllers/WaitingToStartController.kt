package fr.npldev.tetris.controllers

import fr.npldev.tetris.TetrisApp
import javafx.event.ActionEvent
import javafx.fxml.FXML

class WaitingToStartController {
    private lateinit var app: TetrisApp

    fun setApp(app: TetrisApp) {
        this.app = app
    }

    @FXML
    fun startGame(event: ActionEvent) {
        app.startGame()
    }

    @FXML
    fun quitGame(event: ActionEvent) {
        app.quit()
    }
}
