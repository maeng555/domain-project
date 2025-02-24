package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest  {
    @DisplayName("password 초기화 한다")
    @Test
    void passwordTest() {
        //given
        User user = new User();
        //when
        //user.initPassword(new  CorrectFixedPasswordGenerator());
        user.initPassword(()->"abcdefgh");
        //then
        assertThat(user.getPassword()).isNotBlank(); //
    }
    @DisplayName("password가 요구사항에 부합되지않아  초기화 하지 않는다")
    @Test
    void passwordTest2() {
        //given
        User user = new User();
        //when
        //user.initPassword(new  WrongFixedPasswordGenerator());
        user.initPassword(()->"ab");  //@funtinalinterface를 사용하면 람다형식으로 표현할수잇다
        //then
        assertThat(user.getPassword()).isNull(); // 계속 두글자이므로 null 값
    }
}