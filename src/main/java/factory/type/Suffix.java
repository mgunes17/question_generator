package factory.type;

/**
 * Created by mustafa on 29.03.2017.
 */
public enum Suffix {
    PLAIN(new PlainQuestion()),
    DATIVE(new DatQuestion()),
    ABLATIVE(new AblQuestion()),
    ACCUSATIVE(new AccQuestion()),
    LOCATIVE(new LocQuestion()),
    NONE;

    private QuestionType questionType;

    Suffix(QuestionType questionType) {
        this.questionType = questionType;
    }

    Suffix(){
        //non-arg cons
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}