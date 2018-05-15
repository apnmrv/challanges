package ru.apnmrv.challenges.myVoc.services;

import org.junit.Before;
import org.junit.Test;
import ru.apnmrv.challenges.myVoc.services.UriParser;

public class UriParserTest {

    private UriParser parser;
    private String uri;

    @Before
    public void setUp() throws Exception {
        parser = new UriParser();
        uri = "https://www.google.com/search?q=java+regular+expressions&ie=utf-8&oe=utf-8&client=firefox-b-ab";
    }

    @Test
    public void getUrl() {
        System.out.println(parser.getUrl(uri));
    }

    @Test
    public void getUriParameters() {
        System.out.println(parser.getUriParameters(uri));
    }
}