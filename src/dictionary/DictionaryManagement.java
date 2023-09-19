package dictionary;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DictionaryManagement {
    private final Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Set<Map.Entry<String, Word>> getEntrySet() {
        return dictionary.getEntrySet();
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
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./data/dictionaries.txt"));

        while (scanner.hasNextLine()) {
            String lineFetched = scanner.nextLine();
            String[] wordsArr = lineFetched.split("\t");
            if (wordsArr.length == 2)
                dictionary.addNewWord(wordsArr[0], wordsArr[1]);
            else System.out.println("Error input: " + wordsArr.length + " words");
        }

        scanner.close();
    }

    public void dictionaryExportToFile() throws IOException {
        try (PrintWriter pw = new PrintWriter(new File("./data/dictionaries.txt"))) {
            for (Map.Entry<String, Word> mapElement : dictionary.getEntrySet()) {
                String wordTarget = mapElement.getKey();
                String wordExplain = mapElement.getValue().getExplain();
                String line = wordTarget + "\t" + wordExplain;
                pw.println(line);
            }
        }
    }

    public void editFromCommandline() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word: ");
        String wordTarget = scanner.nextLine();
        if (dictionary.hasWord(wordTarget)) {
            System.out.print("Enter the meaning: ");
            String wordExplain = scanner.nextLine();
            dictionary.editWord(wordTarget, wordExplain);
        } else System.out.println("The word isn't existed, please try again.");
    }

    public void removeFromCommandLine() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word: ");
        String wordTarget = scanner.nextLine();

        if (dictionary.hasWord(wordTarget))
            dictionary.removeWord(wordTarget);
        else System.out.println("The word isn't existed, please try again.");
    }

    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Target: ");
        String wordTarget = scanner.nextLine();
        if (dictionary.hasWord(wordTarget))
            System.out.println("Meaning: " + dictionary.getWord(wordTarget).getExplain());
        else System.out.println("The word isn't existed.");
    }

    public void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Target: ");
        String wordTarget = scanner.nextLine();
        Set<String> keyTarget = dictionary.getTailMap(wordTarget);
        System.out.println(keyTarget);
    }
}
