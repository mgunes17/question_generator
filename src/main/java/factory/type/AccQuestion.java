package factory.type;

import word.Question;
import word.Word;

import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public class AccQuestion extends SuffixQuestion implements QuestionType {
    private final String NEYI = "neyi";
    private final String KIMI = "kimi";
    private final String NEREYI = "nereyi";

    public List<Question> reorganize(List<Word> wordList) {
        return super.reorganize(wordList, Suffix.ACCUSATIVE, chooseQuestionWord());
    }

    protected String chooseQuestionWord() {
        return NEREYI;
    }
}
