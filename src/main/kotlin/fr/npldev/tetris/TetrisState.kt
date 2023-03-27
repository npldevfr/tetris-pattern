package fr.npldev.tetris

import javafx.scene.input.KeyEvent

interface TetrisState {
    fun handleInput(gameBoard: GameBoard, input: KeyEvent)
    fun update(gameBoard: GameBoard)
}
