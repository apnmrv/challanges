package ru.apnmrv.challenges.myVoc.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YTranslator implements ITranslator {

    private static final String URL
            = "https://translate.yandex.net/api/v1.5/tr/";
    private static final String API_KEY
            = "key=trnsl.1.1.20180515T061531Z.98f463167c8c1209.0fafbeba516fe4547ccde7af6ebcd4a26173d80c";
    private IBrowser browser;
    private String translation;

    public YTranslator(IBrowser browser){
        this.browser = browser;
    };

    @Override
    public Map<String, String> getAvailableLanguages(String uiLang) {

        Map<String, String> langs = new HashMap<>();

        String urlParameters = API_KEY +
                "&" +
                "ui="+uiLang;
        String langsPattern = "(?s)(.*<langs>)(.*)(</langs>.*)";
        String codePattern = "(?i)(.*key=\")(\\w*)(\".*)";
        String namePattern = "(?i)(.*value=\")(.*)(\".*)";
        String response = "";

        try {
            response = browser.makePost(URL +"getLangs", urlParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = response.replaceAll(langsPattern, "$2");
        List<String> lines = Arrays.asList(response.split("><"));
        String k;
        String v;

        for ( String line : lines ) {
            k = line.replaceAll(codePattern, "$2");
            v = line.replaceAll(namePattern, "$2");
            langs.put(k, v);
        }

        return langs;
    }

    @Override
    public String detectLanguageOf(String text) {

        String urlParameters = API_KEY +
                "&" +
                "text="+text;
        String pattern = "(?si)(.*lang=\")(.*)(\".*)";


        try {
            return browser
                    .makePost(URL +"detect", urlParameters)
                    .replaceAll(pattern, "$2");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String translateIt(String text, String lang) {
        detectLanguageOf(text);
        String urlParameters = API_KEY +
                "&" +
                "text="+text +
                "&" +
                "lang="+lang+
                "&" +
                "format=plain";
        String pattern = "(?si)(.*<text>)(.*)(</text>.*)";

        try {
            this.translation = browser.makePost(URL+"translate", urlParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.translation = this.translation.replaceAll(pattern, "$2");
        return this.translation;
    }
}
