package fr.npldev.tetris;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@DisplayName("Tetronimo Factory Test")
public class TetrominoFactoryTest {

    private static Tetromino tetromino ;

    @BeforeAll
    public static void init(){
        tetromino = TetrominoFactory.INSTANCE.createRandomTetromino();
    }

    @TestFactory
    public Iterable<DynamicTest> multiple_tests(){
        ArrayList<Color> colors = new ArrayList(Arrays.asList(Color.YELLOW, Color.BLUE, Color.YELLOW, Color.CYAN, Color.PINK, Color.GREEN, Color.RED));
        Tetromino temp = tetromino;
        for(int i=0;i<3;i ++) tetromino.rotate();
        return Arrays.asList(
                DynamicTest.dynamicTest("Is subClass of Tetronimo ?",
                        () -> Assertions.assertTrue(Tetromino.class.isAssignableFrom(tetromino.getClass()))),
                DynamicTest.dynamicTest("Has a color ?",
                        () -> Assertions.assertTrue(Tetromino.class.isAssignableFrom(tetromino.getClass()))),
                DynamicTest.dynamicTest("4 rotates equals initial position",
                        () ->  Assertions.assertArrayEquals(tetromino.getShape(),temp.getShape()))

        );
    }
}