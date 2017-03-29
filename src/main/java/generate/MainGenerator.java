package generate;

import factory.QuestionFactory;
import morphology.SentenceAnalyzer;
import word.Question;

import java.io.IOException;
import java.util.List;

/**
 * Created by mustafa on 22.03.2017.
 */
public class MainGenerator {
    public static void main(String[] args) throws IOException {
        String s1 = "Yarın sabah Ankara' ya gidiyorum.";
        QuestionFactory factory = new QuestionFactory(s1, SentenceAnalyzer.getSentenceAnalyzer());

        List<Question> questions = factory.getQuestionList();

        for(Question question: questions) {
            System.out.println(question.getQuestionSentence());
            System.out.println(question.getAnswer());
        }
    }
}
