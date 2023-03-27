module fr.npldev.tetris {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    exports fr.npldev.tetris;
    exports fr.npldev.tetris.controllers;
    opens fr.npldev.tetris to javafx.fxml;
    opens fr.npldev.tetris.controllers to javafx.fxml;
}