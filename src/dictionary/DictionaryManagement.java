package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class DictionaryManagement {
    private final Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return this.dictionary;
    }

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of new words: ");
        int amount = 0;
        while (true) {
            String input = scanner.next();
            try {
                amount = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne) {
                System.out.print("Please enter the number: ");
            }
        }
        scanner.nextLine();

        while (amount-- > 0) {
            System.out.print("Enter new English word: ");
            String wordTarget = scanner.nextLine();
            System.out.print("Enter the meaning: ");
            String wordExplain = scanner.nextLine();

            dictionary.addNewWord(wordTarget, wordExplain);
        }

        scanner.close();
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./data/dictionaries.txt"));

        while(scanner.hasNextLine()) {
            String lineFetched = scanner.nextLine();
            String[] wordsArr = lineFetched.split("\t");
            dictionary.addNewWord(wordsArr[0], wordsArr[1]);
        }

        scanner.close();
    }

    public void dictionaryExportToFile() throws IOException {
        FileWriter fw = new FileWriter(new File("./data/dictionaries.txt"));
        for (Map.Entry<String, Word> mapElement : dictionary.getWordArray().entrySet()) {
            String wordTarget = mapElement.getKey();
            String wordExplain = mapElement.getValue().getExplain();
            String line = wordTarget + "\t" + wordExplain + "\n";
            fw.write(line);
        }
    }

    public Word dictionaryLookup(String wordTarget) {
        return dictionary.getWord(wordTarget);
    }
}
