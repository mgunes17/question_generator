package factory.type;

import word.Question;
import word.Word;

import java.util.List;

/**
 * Created by mustafa on 28.03.2017.
 */
public class AblQuestion extends SuffixQuestion implements QuestionType {
    private final String NEDEN = "neden";
    private final String KIMDEN = "kimden";
    private final String NEREDEN = "nereden";

    public List<Question> reorganize(List<Word> wordList) {
        return super.reorganize(wordList, Suffix.ABLATIVE, chooseQuestionWord());
    }

    protected String chooseQuestionWord() {
        return NEREDEN;
    }
}
