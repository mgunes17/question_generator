package factory.type;

import morphology.SentenceAnalyzer;
import word.Question;
import word.Word;
import zemberek.morphology.analysis.SentenceAnalysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mustafa on 26.03.2017.
 */
public class TimeQuestion implements QuestionType {
    private final String QUESTION_WORD = "ne zaman";
    private final Set<String> keywords = new HashSet<String>();

    public List<Question> reorganize(List<Word> wordList) {
        keywords.add("Time");
        keywords.add("Clock");
        keywords.add("Date");

        StringBuilder builder = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        SentenceAnalysis analysis = SentenceAnalyzer.getSentenceAnalyzer().analyze("");
        SentenceAnalyzer.getSentenceAnalyzer().disambiguate(analysis);

        for (Word word : wordList) {

            if(!keywords.contains(word.getSecondaryPos())) {
                builder.append(word.getWord() + " ");
            } else {
                builder.append(QUESTION_WORD + " ");
                answer.append(word.getWord() + " ");
            }
        }

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question(builder.toString() + " ?", answer.toString(), new TimeQuestion()));
        return questions;
    }
}
