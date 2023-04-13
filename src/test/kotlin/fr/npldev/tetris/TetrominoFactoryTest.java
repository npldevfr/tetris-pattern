package fr.npldev.tetris;

import fr.npldev.tetris.shapes.ITetromino;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/***
 * Classe de Test sur les tetromino de manière générique
 *
 * @see TetrominoFactory
 *      Puis chaque sur chaque tetromino, héritant de la classe Tetromino
 * @see Tetromino
 * @version 1.0.0
 */
@DisplayName("Tetronimo Factory Test")
public class TetrominoFactoryTest {

    private static Tetromino tetromino;

    @BeforeAll
    public static void init() {
        tetromino = TetrominoFactory.INSTANCE.createRandomTetromino();
    }

    @Test
    public void isSubClassTetronimo() {
        Assertions.assertTrue(Tetromino.class.isAssignableFrom(tetromino.getClass()));
        Assertions.assertTrue(tetromino != null);
    }

    @Test
    public void hasColor() {
        ArrayList<Color> colors = new ArrayList(
                Arrays.asList(Color.YELLOW, Color.BLUE, Color.YELLOW, Color.CYAN, Color.PINK, Color.GREEN, Color.RED));
        Assertions.assertTrue(colors.contains(tetromino.getColor()));
    }

    @Test
    public void rotateToInitialPosition() {
        Tetromino temp = tetromino;
        for (int i = 0; i < 3; i++)
            tetromino.rotate();
        Assertions.assertArrayEquals(tetromino.getShape(), temp.getShape());
    }

    @Test
    public void rotations() {
        Tetromino temp = tetromino;
        for (int i = 0; i < 3; i++) {
            temp.rotate();
            for (int j = 0; j < i - 1; j++) {
                tetromino.rotate();
            }
        }
        Assertions.assertArrayEquals(tetromino.getShape(), temp.getShape());
    }

}