package save;

import morphology.SentenceAnalyzer;
import word.Sentence;

import java.util.List;

/**
 * Created by mustafa on 31.03.2017.
 */
public interface SaveType {
    boolean save(List<Sentence> sentenceList);
}
