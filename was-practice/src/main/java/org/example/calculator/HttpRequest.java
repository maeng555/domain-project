package org.example.calculator;

import org.example.QueryStrings;
import org.example.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }
    public QueryStrings getQueryStrings(){

        return requestLine.getQueryStrings();
    }

    public boolean isGetRequest() {
        return requestLine.isGetRuqest();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }
}
