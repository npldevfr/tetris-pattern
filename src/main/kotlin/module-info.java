module fr.npldev.tetris {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens fr.npldev.tetris to javafx.fxml;
    exports fr.npldev.tetris;
}