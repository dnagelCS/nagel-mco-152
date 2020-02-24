package nagel.scrabble;

import org.junit.Test;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;

public class ScrabbleTest {

    @Test
    public void isWord() throws FileNotFoundException {
        //given
        Scrabble scrabble = new Scrabble();
        scrabble.readFile("C://Users//Devora//IdeaProjects//Nagel-MCO152//src//nagel//scrabble//dictionary.txt");

        //when
        boolean exist = scrabble.isWord("AH");

        //then
        assertEquals(true, exist);
    }

    @Test
    public void isNotWord() throws FileNotFoundException {
        //given
        Scrabble scrabble = new Scrabble();
        scrabble.readFile("C://Users//Devora//IdeaProjects//Nagel-MCO152//src//nagel//scrabble//dictionary.txt");

        //when
        boolean exist = scrabble.isWord("devora");

        //then
        assertEquals(false, exist);
    }

    @Test
    public void ignoreCase() throws FileNotFoundException {
        Scrabble scrabble = new Scrabble();
        scrabble.readFile("C://Users//Devora//IdeaProjects//Nagel-MCO152//src//nagel//scrabble//dictionary.txt");

        boolean exist = scrabble.isWord("ah");
        assertEquals(true, exist);

        exist = scrabble.isWord("Ah");
        assertEquals(true, exist);

        exist = scrabble.isWord("aH");
        assertEquals(true, exist);
    }

}
