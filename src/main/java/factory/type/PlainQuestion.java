package factory.type;

import factory.type.suffix.Suffix;
import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ercan on 29.03.2017.
 */
public class PlainQuestion implements QuestionType {
    private final String KIM = "kim";
    private final String NE = "ne";

    public List<Question> reorganize(List<Word> wordList) {

        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(word.getSuffix() != Suffix.PLAIN) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append(KIM + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), new PlainQuestion()));

        return questions;
    }
}
