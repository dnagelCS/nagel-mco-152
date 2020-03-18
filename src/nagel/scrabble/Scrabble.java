package nagel.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Scrabble {
    private final Set<String> set = new HashSet<>();

    public Scrabble() throws FileNotFoundException {
        File file = new File("src/nagel/scrabble/dictionary.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            set.add(nextWord);
            scanner.nextLine();
        }
    }

    //check if the word exists
    public boolean isWord(String word) {
            word = word.toUpperCase();
            return set.contains(word);
    }
}
