package dictionary;

public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getExplain() {
        return this.word_explain;
    }

    public void editWord(String wordTarget, String wordExplain) {
        this.word_target = wordTarget;
        this.word_explain = wordExplain;
    }

}
