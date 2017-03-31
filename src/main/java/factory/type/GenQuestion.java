package factory.type;

import morphology.SentenceAnalyzer;
import word.Question;
import word.Word;
import zemberek.morphology.analysis.SentenceAnalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 31.03.2017.
 */
public class GenQuestion implements QuestionType {
    private final String NERENIN = "nerenin";
    private final String KIMIN = "kimin";
    private final String NEYIN = "neyin";

    public List<Question> reorganize(List<Word> wordList) {
        StringBuilder builder = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        SentenceAnalysis analysis = SentenceAnalyzer.getSentenceAnalyzer().analyze("");
        SentenceAnalyzer.getSentenceAnalyzer().disambiguate(analysis);

        for (Word word : wordList) {

            if(!word.isGen()) {
                builder.append(word.getWord() + " ");
            } else {
                builder.append(" " + NEYIN + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(builder.toString() + " ?", answer.toString(), new GenQuestion()));
        return questions;
    }
}
