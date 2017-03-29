package factory.type;

import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public class DatQuestion implements QuestionType {
    private final String NEYE = "neye";
    private final String KIME = "kime";
    private final String NEREYE = "nereye";

    public List<Question> reorganize(List<Word> wordList) {

        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(word.getSuffix() != Word.Suffix.DATIVE) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append(NEREYE + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), new AblQuestion()));

        return questions;
    }
}
