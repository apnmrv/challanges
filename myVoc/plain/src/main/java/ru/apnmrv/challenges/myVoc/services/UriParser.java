package ru.apnmrv.challenges.myVoc.services;

public class UriParser implements IUriParser {

    private static final String URI_PATTERN = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private String url = "";
    private String urlParameters = "";


    public UriParser(){ }

    @Override
    public String getUrl(String uri) {
        this.url = uri.replaceAll(URI_PATTERN, "$1$3$5");
        return this.url;
    }

    @Override
    public String getUriParameters(String uri) {
        return uri.replaceAll(URI_PATTERN, "$7");
    }
}
