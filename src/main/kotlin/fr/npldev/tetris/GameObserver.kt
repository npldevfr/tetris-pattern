package fr.npldev.tetris

interface GameObserver {
    fun update()
}

class GameSubject {
    private val observers = mutableListOf<GameObserver>()

    fun addObserver(observer: GameObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: GameObserver) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach {
            it.update()
        }
    }

}