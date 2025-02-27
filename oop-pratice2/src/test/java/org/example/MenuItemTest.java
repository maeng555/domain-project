package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuItemTest {
    @DisplayName("메뉴를 생성한다 ")
    @Test
    void name() {
        assertThatCode(()->new MenuItem("만두",5000))
                .doesNotThrowAnyException();
    }
}
