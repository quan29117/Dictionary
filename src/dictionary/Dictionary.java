package dictionary;

import java.util.TreeMap;

public class Dictionary {
    private final TreeMap<String, Word> wordArray;

    public Dictionary() {
        this.wordArray = new TreeMap <String, Word>();
    }

    public TreeMap <String, Word> getWordArray() {
        return this.wordArray;
    }

    public Word getWord(String wordTarget) {
        return wordArray.get(wordTarget);
    }

    public void addNewWord(String wordTarget, String wordExplain) {
        this.wordArray.put(wordTarget, new Word (wordTarget, wordExplain));
    }

    public boolean hasWord(String wordTarget) {
        return wordArray.containsKey(wordTarget);
    }

    public void editWord(String wordTarget, String wordExplain) {
        this.wordArray.get(wordTarget).editExplain(wordExplain);
    }
}
