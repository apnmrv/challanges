package ru.apnmrv.challenges.myVoc.domain;

import java.util.Map;

public class Word {
    private String spelling;
    private String language;
    private Map<String, String> translations;

    public Word(String spelling, String language) {
        this.spelling = spelling;
        this.language = language;
    }

    public String getTranslation (String lang) {
        return translations.get(lang);
    }

    public void addTranslation (String lang, String translation) {
        this.translations.put(lang, translation);
    }

    public void addTranslations (Map translations) {
        this.translations = translations;
    }

    public Map<String, String> getAllTranslations () {
        return this.translations;
    }
}
