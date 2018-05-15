package ru.apnmrv.challenges.myVoc.services;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class YTranslatorTest {
    private ITranslator translator;
    private String text;
    private String trgLang;
    private Map<String, String> langs;


    @Before
    public void setUp() throws Exception {
        translator = new YTranslator(new Browser());
        text = "яблоко";
        trgLang = "de";
    }

    @Test
    public void detectLanguageOf() {
        System.out.println(translator.detectLanguageOf(text));
    }

    @Test
    public void translateIt() {
        System.out.println(translator.translateIt(text, trgLang));
    }

    @Test
    public void getAvailableLanguages() {
        langs = translator.getAvailableLanguages("ru");
        System.out.println(langs);
    }
}