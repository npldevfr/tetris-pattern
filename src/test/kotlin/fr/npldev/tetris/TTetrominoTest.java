package fr.npldev.tetris;

import fr.npldev.tetris.shapes.TTetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TTetromino test class ")
public class TTetrominoTest {

    private static TTetromino tTetromino;

    @BeforeAll
    public static void init() {
        tTetromino = new TTetromino();
    }

    @Test
    public void check_array_TTetromino() {
        Integer[][] array = { { 0, 0, 0 },
                { 1, 1, 1 },
                { 0, 1, 0 }, };
        Assertions.assertArrayEquals(array, tTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.PURPLE, tTetromino.getColor());
    }
}