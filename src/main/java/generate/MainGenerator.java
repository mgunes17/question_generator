package generate;

import factory.QuestionFactory;
import morphology.SentenceAnalyzer;
import save.FileSave;
import save.SaveType;
import word.Question;
import word.Sentence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mustafa on 22.03.2017.
 */
public class MainGenerator {
    private QuestionFactory factory;
    private final String EXIT = "exit";
    private final String ASK = "ask";
    private final String SAVE = "save";
    private final String CHANGE = "change";
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        MainGenerator generator = new MainGenerator();
        SentenceAnalyzer.getSentenceAnalyzer();
        generator.run();
    }

    private void run() {
        System.out.print("command=>");
        String command = in.nextLine();

        while(!command.equals(EXIT)) {
            if(command.equals(SAVE)) {
                boolean result = save();
                if(result)
                    System.out.println("Dosya oluşturuldu");
                else
                    System.out.println("Bir hata meydana geldi");
            } else if(command.equals(ASK)) {
                ask();
            } else {
                System.out.println("Command not found");
            }

            System.out.print("command=>");
            command = in.nextLine();
        }
    }

    private void ask() {
        System.out.print("sentence=>");
        String sentence = in.nextLine();

        while(!sentence.equals("change")) {
            convertQuestions(sentence);
            System.out.print("sentence=>");
            sentence = in.nextLine();
        }
    }

    private boolean save() {
        List<String> sentenceList = new ArrayList<String>();
        sentenceList.add("Türkiye'nin başkenti Ankara'dır .");
        sentenceList.add("Yarın sabah İstanbul' dan dönecek .");
        sentenceList.add("Elmaların 5te 2sini yedi .");
        sentenceList.add("Kitabı bitireli çok oldu .");
        sentenceList.add("Elmaların 60ını suya düşürdü .");
        sentenceList.add("O elmaların 6da 2sinin yarısını yedi .");

        List<Sentence> sentences = new ArrayList<Sentence>();

        for(String sentence: sentenceList) {
            Sentence sentence1 = new Sentence(sentence);
            sentence1.setQuestionList(convertQuestions(sentence));
        }

        SaveType saveType = new FileSave();
        return saveType.save(sentences);
    }

    private List<Question> convertQuestions(String sentence) {
        factory = new QuestionFactory(sentence);
        Sentence sentence1 = factory.getQuestionList();
        List<Question> questions = sentence1.getQuestionList();

        for(Question question: questions) {
            System.out.println(question.getQuestionSentence());
            System.out.println(question.getAnswer());
        }

        return questions;
    }
}