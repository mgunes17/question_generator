package word;

import factory.type.QuestionType;

/**
 * Created by mustafa on 29.03.2017.
 */
public class Question {
    private final String questionSentence;
    private final String answer;
    private final QuestionType questionType;

    public Question(String questionSentence, String answer, QuestionType questionType) {
        this.questionSentence = questionSentence;
        this.answer = answer;
        this.questionType = questionType;
    }

    //getter-setter
    public String getQuestionSentence() {
        return questionSentence;
    }

    public String getAnswer() {
        return answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}
