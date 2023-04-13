package fr.npldev.tetris;

import fr.npldev.tetris.shapes.STetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OTEtromino test class ")
public class STetrominoTest {

    private static STetromino sTetromino;

    @BeforeAll
    public static void init() {
        sTetromino = new STetromino();
    }

    @Test
    public void check_array_STetromino() {
        Integer[][] array = { { 0, 1, 1 },
                { 1, 1, 0 },
                { 0, 0, 0 }, };
        Assertions.assertArrayEquals(array, sTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.GREEN, sTetromino.getColor());
    }
}
