package fr.npldev.tetris

import javafx.scene.input.KeyEvent

interface TetrisState {
    fun handleKeyEvent(tetrisApp: TetrisApp, gameBoard: GameBoard, event: KeyEvent)
    fun update(tetrisApp: TetrisApp, gameBoard: GameBoard)
}


