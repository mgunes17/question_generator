package factory.type;

import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 28.03.2017.
 */
public class AblQuestion implements QuestionType {
    private final String NEDEN = "neden";
    private final String KIMDEN = "kimden";
    private final String NEREDEN = "nereden";

    public List<Question> reorganize(List<Word> wordList) {

        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(word.getSuffix() != Word.Suffix.ABLATIVE) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append("nereden" + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), new AblQuestion()));

        return questions;
    }


}
