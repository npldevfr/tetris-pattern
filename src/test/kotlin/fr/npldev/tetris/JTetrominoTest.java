package fr.npldev.tetris;

import fr.npldev.tetris.shapes.JTetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JTetronimo test class ")
public class JTetrominoTest {

    private static JTetromino jTetromino;

    @BeforeAll
    public static void init() {
        jTetromino = new JTetromino();
    }

    @Test
    public void check_array_JTetromino() {
        Integer[][] array = { { 0, 0, 0 },
                { 1, 1, 1 },
                { 0, 0, 1 }, };
        Assertions.assertArrayEquals(array, jTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.BLUE, jTetromino.getColor());
    }
}
