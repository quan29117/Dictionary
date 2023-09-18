package dictionary;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class DictionaryCommandLine {
    private final DictionaryManagement dictManagement;

    public DictionaryCommandLine(Dictionary dictionary) {
        this.dictManagement = new DictionaryManagement(dictionary);
    }

    private void printWordLine(String num, String English, String Vietnamese) {
        System.out.println(num + "    " + English + "    " + Vietnamese);
    }

    public void showAllWords() {
        printWordLine("No", "English", "Vietnamese");

        int no = 0;
        for (Map.Entry<String, Word> mapElement : dictManagement.getDictionary().getWordArray().entrySet()) {
            no++;
            printWordLine(String.valueOf(no), mapElement.getKey(), mapElement.getValue().getExplain());
        }
    }

    public void dictionaryAdvanced() throws IOException {
        Scanner scanner = new Scanner(System.in);

        loop : do {
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit\n[1] Add\n[2] Remove\n[3] Update\n[4] Display\n[5] Lookup");
            System.out.println("[6] Search\n[7] Game\n[8] Import from file\n[9] Export to file");
            System.out.print("Your action: ");

            int id = scanner.nextInt();
            scanner.nextLine();

            switch (id) {
                case 0 -> {
                    System.out.println("Goodbye Master");
                    break loop;
                }

                case 1 -> {
                    dictManagement.insertFromCommandline();
                }

                case 2 -> {

                }

                case 3 -> {
                    dictManagement.editFromCommandline();
                }

                case 4 -> {
                    this.showAllWords();
                }

                case 5 -> {

                }

                case 6 -> {

                }

                case 7 -> {

                }
                case 8 -> dictManagement.insertFromFile();
                case 9 -> dictManagement.dictionaryExportToFile();
            }

            System.out.print("Press any key to continue...");
            System.in.read();
        } while (true);
    }
}
