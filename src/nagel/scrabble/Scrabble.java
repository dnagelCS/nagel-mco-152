package nagel.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scrabble {
    HashSet<String> set = new HashSet<>();

    //read file and place words in set
    public void readFile(String pathName) throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.nextLine();
            set.add(nextWord.toLowerCase());
        }
    }

    //check if the word exists
    public boolean isWord(String word) throws FileNotFoundException {
            word = word.toLowerCase();
            Collection<String> firstWords = (Collection<String>) set.stream().map(s -> s.split(" ")[0]).collect(Collectors.toSet());
            if (firstWords.contains(word)) {
                return true;
            }
        return false;
    }
}
