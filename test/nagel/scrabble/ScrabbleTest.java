package nagel.scrabble;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;

public class ScrabbleTest {
    Scrabble scrabble = new Scrabble();

    public ScrabbleTest() throws FileNotFoundException {
    }

    @Test
    public void isWord() throws FileNotFoundException {
        //given
        scrabble = new Scrabble();

        //when
        boolean exist = scrabble.isWord("AH");

        //then
        assertEquals(true, exist);
    }

    @Test
    public void isNotWord() throws FileNotFoundException {
        //given
        scrabble = new Scrabble();

        //when
        boolean exist = scrabble.isWord("devora");

        //then
        assertEquals(false, exist);
    }

    @Test
    public void ignoreCase() throws FileNotFoundException {
        scrabble = new Scrabble();

        boolean exist = scrabble.isWord("ah");
        assertEquals(true, exist);

        exist = scrabble.isWord("Ah");
        assertEquals(true, exist);

        exist = scrabble.isWord("aH");
        assertEquals(true, exist);
    }

}
