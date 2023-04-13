package fr.npldev.tetris;

import fr.npldev.tetris.shapes.LTetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LTetronimo test class ")
public class LTetrominoTest {

    private static LTetromino lTetromino;

    @BeforeAll
    public static void init() {
        lTetromino = new LTetromino();
    }

    @Test
    public void check_array_LTetromino() {
        Integer[][] array = { { 0, 0, 0 },
                { 1, 1, 1 },
                { 1, 0, 0 }, };
        Assertions.assertArrayEquals(array, lTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.YELLOW, lTetromino.getColor());
    }
}
