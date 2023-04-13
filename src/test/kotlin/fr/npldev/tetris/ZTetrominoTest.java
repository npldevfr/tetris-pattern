
package fr.npldev.tetris;

import fr.npldev.tetris.shapes.TTetromino;
import fr.npldev.tetris.shapes.ZTetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ZTetromino test class ")
public class ZTetrominoTest {

    private static ZTetromino zTetromino;

    @BeforeAll
    public static void init() {
        zTetromino = new ZTetromino();
    }

    @Test
    public void check_array_ZTetromino() {
        Integer[][] array = { { 1, 1, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 }, };
        Assertions.assertArrayEquals(array, zTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.RED, zTetromino.getColor());
    }
}