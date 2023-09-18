package dictionary;

public class Word {
    private final String word_target;
    private final String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getExplain() {
        return this.word_explain;
    }
}
