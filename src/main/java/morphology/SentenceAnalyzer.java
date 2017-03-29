package morphology;

import zemberek.morphology.ambiguity.Z3MarkovModelDisambiguator;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.io.IOException;

/**
 * Created by mustafa on 28.03.2017.
 */
public class SentenceAnalyzer {
    private static TurkishSentenceAnalyzer sentenceAnalyzer;

    public static TurkishSentenceAnalyzer getSentenceAnalyzer() {
        if(sentenceAnalyzer == null)
            createSentenceAnalyzer();

        return sentenceAnalyzer;
    }


    private static void createSentenceAnalyzer() {
        TurkishMorphology morphology = null;
        try {
            morphology = TurkishMorphology.createWithDefaults();
            Z3MarkovModelDisambiguator disambiguator = new Z3MarkovModelDisambiguator();
            sentenceAnalyzer = new TurkishSentenceAnalyzer(
                    morphology,
                    disambiguator
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
