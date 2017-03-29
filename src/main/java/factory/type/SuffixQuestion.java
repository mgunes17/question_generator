package factory.type;

import word.Question;
import word.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 29.03.2017.
 */
public abstract class SuffixQuestion {
    protected abstract String chooseQuestionWord();

    public List<Question> reorganize(List<Word> wordList, Suffix suffix, String qw) {
        StringBuilder sentence = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (Word word : wordList) {
            if(word.getSuffix() != suffix) {
                sentence.append(word.getWord() + " ");
            } else {
                sentence.append(qw + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(sentence.toString() + " ?", answer.toString(), suffix.getQuestionType()));

        return questions;
    }
}
