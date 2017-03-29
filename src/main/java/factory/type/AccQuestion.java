package factory.type;

import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public class AccQuestion implements QuestionType {
    private final String NEYI = "neyi";
    private final String KIMI = "kimi";
    private final String NEREYI = "nereyi";

    public List<Question> reorganize(List<Word> wordList) {

        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(word.getSuffix() != Word.Suffix.ACCUSATIVE) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append(NEREYI + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), new AblQuestion()));

        return questions;
    }
}
