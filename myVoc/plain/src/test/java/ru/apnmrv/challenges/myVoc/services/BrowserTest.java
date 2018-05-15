package ru.apnmrv.challenges.myVoc.services;

import org.junit.Before;
import org.junit.Test;
import ru.apnmrv.challenges.myVoc.services.Browser;

import java.io.IOException;

import static org.junit.Assert.*;

public class BrowserTest {

    private Browser b;


    @Before
    public void setUp() throws Exception {
        b = new Browser();
    }

    @Test
    public void makeGet() {
        try {
            assertNotNull(b.makeGet("https://www.google.com"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makePost() {
        try {
            assertNotNull(b.makePost("http://alamed.ru/good/266/",
                    ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}