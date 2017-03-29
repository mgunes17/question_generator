package factory.type;

import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ercan on 29.03.2017.
 */
public class CopQuestion implements QuestionType {
    private final String NEDIR = "nedir";

    public List<Question> reorganize(List<Word> wordList) {

        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(!word.isCopQuestion()) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append(NEDIR + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), new CopQuestion()));

        return questions;
    }
}
