package fr.npldev.tetris;

import fr.npldev.tetris.shapes.OTetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OTEtromino test class ")
public class OTetrominoTest {

    private static OTetromino oTetromino;

    @BeforeAll
    public static void init() {
        oTetromino = new OTetromino();
    }

    @Test
    public void check_array_OTetromino() {
        Integer[][] array = { { 1, 1 },
                { 1, 1, }, };
        Assertions.assertArrayEquals(array, oTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.PINK, oTetromino.getColor());
    }
}
