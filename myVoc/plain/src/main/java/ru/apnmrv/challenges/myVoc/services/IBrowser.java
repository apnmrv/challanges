package ru.apnmrv.challenges.myVoc.services;

import java.io.IOException;

public interface IBrowser {
    public String makeGet (String url) throws IOException;
    public String makePost(String url, String urlParameters) throws IOException;
}
