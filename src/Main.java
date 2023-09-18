import dictionary.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine(dictionary);

        dictionaryCommandLine.dictionaryAdvanced();
    }
}