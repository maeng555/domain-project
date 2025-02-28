package org.example;

import java.util.Arrays;
import java.util.Objects;

public class RequestLine {
    private final String method; //get
    private final String urlPath; // 그다음 url
    private  QueryStrings queryStrings;

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];
        if (urlPathTokens.length > 1) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }

    }


    public boolean isGetRuqest() {
        return "GET".equals(method);
    }

    public boolean matchPath(String path) {
        return urlPath.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
