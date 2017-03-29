package factory.type;

import word.Question;
import word.Word;

import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public class LocQuestion extends SuffixQuestion implements QuestionType {
    private final String NEREDE = "nerede";
    private final String KIMDE = "kimde";

    public List<Question> reorganize(List<Word> wordList) {
        return super.reorganize(wordList, Suffix.LOCATIVE, chooseQuestionWord());
    }

    public String chooseQuestionWord() {
        return NEREDE;
    }
}
