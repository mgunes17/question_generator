package test.MorphologTest;

import zemberek.morphology.ambiguity.Z3MarkovModelDisambiguator;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.io.IOException;

/**
 * Created by mustafa on 20.03.2017.
 */
public class MorphologyTest {
    public static void main(String[] args) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        Z3MarkovModelDisambiguator disambiguator = new Z3MarkovModelDisambiguator();
        TurkishSentenceAnalyzer sentenceAnalyzer = new TurkishSentenceAnalyzer(
                morphology,
                disambiguator
        );

        String s1 = "Ağlamaktan gözlerim kızardı";
        SentenceAnalysis analysis = sentenceAnalyzer.analyze(s1);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s2 = "Başarabileceğimizden hiç şüphem yok";
        analysis = sentenceAnalyzer.analyze(s2);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s3 = "Sevmekten kim usanır";
        analysis = sentenceAnalyzer.analyze(s3);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s4 = "Yarın İstanbul'dan geliyorum.";
        analysis = sentenceAnalyzer.analyze(s4);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s5 = "Okuldan izin vermediler.";
        analysis = sentenceAnalyzer.analyze(s5);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s6 = "Kitabı senden aldım";
        analysis = sentenceAnalyzer.analyze(s6);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s7 = "Kitabı kütüphaneden aldım";
        analysis = sentenceAnalyzer.analyze(s7);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s8 = "En sevdiğim renk mavidir.";
        analysis = sentenceAnalyzer.analyze(s8);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s9 = "Türkiye'nin başkenti Ankara'dır";
        analysis = sentenceAnalyzer.analyze(s9);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s10 = "O çoktan gelmiştir";
        analysis = sentenceAnalyzer.analyze(s10);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong());
        }

        System.out.println("----------------------");
        String s11 = "Ben yarın Ankara'yı İstanbul'dan izleyeceğim.";
        analysis = sentenceAnalyzer.analyze(s11);
        sentenceAnalyzer.disambiguate(analysis);

        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            System.out.println(wa.formatLong() + " " + wa.dictionaryItem.primaryPos.toString() + " " +
            wa.dictionaryItem.secondaryPos);
        }
    }
}
