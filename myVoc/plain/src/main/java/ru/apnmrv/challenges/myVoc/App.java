package ru.apnmrv.challenges.myVoc;

import ru.apnmrv.challenges.myVoc.domain.Language;
import ru.apnmrv.challenges.myVoc.domain.Word;
import ru.apnmrv.challenges.myVoc.services.Browser;
import ru.apnmrv.challenges.myVoc.services.IBrowser;
import ru.apnmrv.challenges.myVoc.services.ITranslator;
import ru.apnmrv.challenges.myVoc.services.YTranslator;

import java.io.IOException;
import java.util.*;

public class App {
    private static IBrowser browser;
    private static ITranslator translator;
    private static String text;
    private static String trgLang;
    private static String uiLang;

    public static void main(String ... args) throws IOException {

        browser = new Browser();
        translator = new YTranslator(browser);
        uiLang = "ru";
        text = "Яблоко";
        trgLang = "fr";
        System.out.println(translator.translateIt(text, trgLang));

        Map<String, String> allAvailableLangs = new HashMap<>();

        allAvailableLangs = translator.getAvailableLanguages(uiLang);

        Word w = new Word ("яблоко", uiLang);

        Map<String, String> translationsOfAGivenWord = new HashMap<String, String>();

        for(String k : allAvailableLangs.keySet()) {
            String v = translator.translateIt(text, k);
            translationsOfAGivenWord.put(k, v);
        }

        w.addTranslations(translationsOfAGivenWord);



        Map<String, Map<String, String>> vocForAGivenLang = new HashMap<>();
    }
}
