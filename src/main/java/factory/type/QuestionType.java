package factory.type;

import word.Question;
import word.Word;

import java.util.List;

/**
 * Created by mustafa on 26.03.2017.
 */
public interface QuestionType {
    List<Question> reorganize(List<Word> wordList);
}
