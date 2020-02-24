package nagel.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Scrabble {
    HashSet<String> set = new HashSet<>();

    //read file and place words in set
    public void readFile(String pathName) throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            set.add(nextWord.toLowerCase());
        }
    }

    //check if the word exists
    public boolean isWord(String word) throws FileNotFoundException {
            word = word.toLowerCase();
            if (set.contains(word)) {
                return true;
            }
        return false;
    }
}
