package ru.apnmrv.challenges.myVoc.services;

import java.util.Map;

public interface ITranslator {
    public Map<String,String> getAvailableLanguages(String uiLang);
    public String detectLanguageOf(String text);
    public String translateIt(String text, String lang);
}
