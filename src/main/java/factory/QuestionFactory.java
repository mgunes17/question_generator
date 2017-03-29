package factory;

import factory.type.*;
import word.Question;
import word.Word;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.util.*;

/**
 * Created by mustafa on 26.03.2017.
 */
public class QuestionFactory {
    private final String sentence;
    private TurkishSentenceAnalyzer analyzer;
    List<Word> wordList = new ArrayList<Word>();
    Set<QuestionType> questionTypeSet = new HashSet<QuestionType>();

    public QuestionFactory(String sentence, TurkishSentenceAnalyzer analyzer) {
        this.sentence = sentence;
        this.analyzer = analyzer;
    }

    public List<Question> getQuestionList() {
        List<Question> generatedList = new ArrayList<Question>();
        Set<String> secondaryPostTags = new HashSet<String>();
        Map<String, QuestionType> tagMap = new HashMap<String, QuestionType>();
        tagMap.put("Time", new TimeQuestion());
        tagMap.put("Clock", new TimeQuestion());
        tagMap.put("Date", new TimeQuestion());


        SentenceAnalysis analysis = analyzer.analyze(sentence);
        analyzer.disambiguate(analysis);

        Word word;
        //secondary pos ları sete at
        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            secondaryPostTags.add(wa.dictionaryItem.secondaryPos.toString());


            word = new Word(entry.input, getSuffix(wa.formatLong() + wa.dictionaryItem.secondaryPos));
            word.setPrimaryPos(wa.dictionaryItem.primaryPos.toString());
            word.setSecondaryPos(wa.dictionaryItem.secondaryPos.toString());
            wordList.add(word);
        }

        //secondary posların soru tipini set e at
        for(String tag: secondaryPostTags) {
            questionTypeSet.add(tagMap.get(tag));
        }

        for(QuestionType type: questionTypeSet) {
            if(type != null) {
                generatedList.addAll(generate(type));
            }
        }

        return generatedList;
    }

    private List<Question> generate(QuestionType type) {
        return type.reorganize(wordList);
    }

    private Suffix getSuffix(String log) {
        if(log.contains("Acc")) {
            questionTypeSet.add(new AccQuestion());
            return Suffix.ACCUSATIVE;
        }
        else if(log.contains("Dat")) {
            questionTypeSet.add(new DatQuestion());
            return Suffix.DATIVE;
        }
        else if(log.contains("Loc")) {
            questionTypeSet.add(new LocQuestion());
            return Suffix.LOCATIVE;
        }
        else if(log.contains("Abl")) {
            questionTypeSet.add(new AblQuestion());
            return Suffix.ABLATIVE;
        } else if(log.contains("ProperNoun")) {
            questionTypeSet.add(new PlainQuestion());
            return Suffix.PLAIN;
        }
        else{
            return Suffix.NONE;
        }
    }
}
