package factory.type;

import word.Question;
import word.Word;

import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public class DatQuestion extends SuffixQuestion implements QuestionType {
    private final String NEYE = "neye";
    private final String KIME = "kime";
    private final String NEREYE = "nereye";

    public List<Question> reorganize(List<Word> wordList) {
        return super.reorganize(wordList, Suffix.DATIVE, chooseQuestionWord());
    }

    protected String chooseQuestionWord() {
        return NEREYE;
    }
}
