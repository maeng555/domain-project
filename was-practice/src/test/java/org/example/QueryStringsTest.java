package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {

    @Test
    void queryStringsTest() {
        QueryStrings queryStrings =new QueryStrings("operand1=11&operator=*&operand2=55");//List
        assertThat(queryStrings).isNotNull();
    }
}
