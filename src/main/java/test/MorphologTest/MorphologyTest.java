package test.MorphologTest;

import factory.QuestionFactory;
import morphology.SentenceAnalyzer;
import word.Question;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Created by mustafa on 20.03.2017.
 */
public class MorphologyTest {
    public static void main(String[] args) throws IOException {
        TurkishSentenceAnalyzer sentenceAnalyzer = SentenceAnalyzer.getSentenceAnalyzer();

        String s1 = "Ercan kapıyı kırdı.";
        SentenceAnalysis analysis = sentenceAnalyzer.analyze(s1);
        sentenceAnalyzer.disambiguate(analysis);
        System.out.println(s1);
        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
            System.out.println(wa.dictionaryItem.primaryPos.toString() + " "
            + wa.dictionaryItem.secondaryPos.toString());
        }

        System.out.println("--------------------");

        String s2 = "Aliyle Ercan eve geldi.";
        sentenceAnalyzer.disambiguate(analysis);
        analysis = sentenceAnalyzer.analyze(s2);
        System.out.println(s2);
        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
            System.out.println(wa.dictionaryItem.primaryPos.toString() + " "
                    + wa.dictionaryItem.secondaryPos.toString());
        }


        System.out.println("---------------------");
        QuestionFactory factory = new QuestionFactory(s1, sentenceAnalyzer);

        List<Question> questions = factory.getQuestionList();

        for(Question question: questions) {
            System.out.println(question.getQuestionSentence());
            System.out.println(question.getAnswer());
        }

    }
}
