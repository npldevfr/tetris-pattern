package fr.npldev.tetris;

import fr.npldev.tetris.shapes.ITetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ITetronimo test class ")
public class ITetrominoTest {

    private static ITetromino iTetromino;

    @BeforeAll
    public static void init() {
        iTetromino = new ITetromino();
    }

    @Test
    public void check_array_ITetromino() {
        Integer[][] array = { { 0, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        Assertions.assertArrayEquals(array, iTetromino.getShape());
    }

    @Test
    void check_color_Tetromino() {
        Assertions.assertEquals(Color.CYAN, iTetromino.getColor());
    }
}
