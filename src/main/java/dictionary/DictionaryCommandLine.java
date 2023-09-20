package dictionary;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class DictionaryCommandLine {
    private final DictionaryManagement dictionaryManagement;

    public DictionaryCommandLine() {
        this.dictionaryManagement = new DictionaryManagement();
    }

    private void printWordLine(String num, String English, String Vietnamese) {
        String space1 = " ".repeat(6 - num.length());
        String space2 = " ".repeat(12 - English.length());
        System.out.println(num + space1 + "| " + English + space2 + "| " + Vietnamese);
    }

    public void showAllWords() {
        printWordLine("No", "English", "Vietnamese");

        int no = 0;
        for (Map.Entry<String, Word> mapElement : dictionaryManagement.getEntrySet()) {
            no++;
            printWordLine(String.valueOf(no), mapElement.getKey(), mapElement.getValue().getExplain());
        }
    }

    public void dictionaryAdvanced() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to My Application!");

        loop:
        do {
            System.out.println("[0] Exit\n[1] Add\n[2] Remove\n[3] Update\n[4] Display\n[5] Lookup");
            System.out.println("[6] Search\n[7] Game\n[8] Import from file\n[9] Export to file");
            System.out.print("Your action: ");

            int id = scanner.nextInt();
            scanner.nextLine();

            switch (id) {
                case 0 -> {
                    System.out.print("Goodbye Master");
                    break loop;
                }

                case 1 -> {
                    dictionaryManagement.insertFromCommandline();
                }

                case 2 -> {
                    dictionaryManagement.removeFromCommandLine();
                }

                case 3 -> {
                    dictionaryManagement.editFromCommandline();
                }

                case 4 -> {
                    this.showAllWords();
                }

                case 5 -> {
                    dictionaryManagement.dictionaryLookup();
                }

                case 6 -> {
                    dictionaryManagement.dictionarySearcher();
                }

                case 7 -> {

                }

                case 8 -> {
                    dictionaryManagement.insertFromFile();
                    System.out.println("The data has been imported!");
                }
                case 9 -> {
                    dictionaryManagement.dictionaryExportToFile();
                    System.out.println("The data has been exported!");
                }
            }


            System.out.print("Press ENTER to continue...");
            scanner.nextLine();
        } while (true);
    }
}
