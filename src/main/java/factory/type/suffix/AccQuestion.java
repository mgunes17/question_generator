package factory.type.suffix;

import factory.type.QuestionType;
import word.Question;
import word.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mustafa on 29.03.2017.
 */
public class AccQuestion extends SuffixQuestion implements QuestionType {
    private final String NEYI = "neyi";
    private final String KIMI = "kimi";
    private final String NEREYI = "nereyi";
    private final String KACI = "kaçı";
    private final String KACINI = "kaçını";
    private final String KACININ = "kaçının";
    private final String NEYINI = "neyini";


    public List<Question> reorganize(List<Word> wordList) {
        Map<Integer, String> changeMap = new HashMap<Integer, String>();

        //soru kelimelerini bul
        int i = 0;
        for(Word word: wordList) {
            if(word.getSuffix() == Suffix.ACCUSATIVE) {
                changeMap.put(i, chooseQuestionWord(word));
            }
            i++;
        }

        return super.reorganize(wordList, changeMap, Suffix.ACCUSATIVE);
    }

    protected String chooseQuestionWord(Word word) {
        if(word.getPrimaryPos().equals("Numeral")) {
            if(word.getLog().contains("Gen"))
                return KACININ;
            else if(word.getLog().contains("P2sg") || word.getLog().contains("P3sg"))
                return KACINI;
            else
                return KACI;
        }
        else if(word.getLog().contains("P2sg") || word.getLog().contains("P3sg"))
            return NEYINI;
        else
            return NEYI;
    }
}
