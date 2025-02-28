package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings{
    private List<QueryString> queryStrings =new ArrayList<>();

    public QueryStrings(String queryStringLine) {
       String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryStringToken -> {
                    String[] values = queryStringToken.split("=");
                    if (values.length == 2) {
                        throw new IllegalArgumentException("Invalid query string: " + queryStringLine);
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
       return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);

    }
}
