package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다 ")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();  //요리사 객체 성공
        MenuItem menuItem = new MenuItem("돈까스",5000); //요리사 메뉴 갖고오기
        Cook cook= cooking.makeCook(menuItem); //요리사에게 부탁 그리고 요리가 있는지 확인하는 정보
        assertThat(cook).isEqualTo(new Cook("돈까스",5000));

    }
}
