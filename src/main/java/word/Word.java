package word;

/**
 * Created by mustafa on 29.03.2017.
 */
public class Word {
    public enum Suffix {
        NONE, DATIVE, ABLATIVE, ACCUSATIVE, LOCATIVE
    }

    private final String word;
    private String primaryPos;
    private String secondaryPos;
    private Suffix suffix;

    public Word(String word, Suffix suffix) {
        this.word = word;
        this.suffix = suffix;
    }

    //getter-setter

    public String getWord() {
        return word;
    }

    public String getPrimaryPos() {
        return primaryPos;
    }

    public void setPrimaryPos(String primaryPos) {
        this.primaryPos = primaryPos;
    }

    public String getSecondaryPos() {
        return secondaryPos;
    }

    public void setSecondaryPos(String secondaryPos) {
        this.secondaryPos = secondaryPos;
    }

    public Suffix getSuffix() {
        return suffix;
    }

    public void setSuffix(Suffix suffix) {
        this.suffix = suffix;
    }
}
