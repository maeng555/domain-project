package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PasswordValidatorTest {
    //커맨드 n
    @DisplayName("비밀번호가 8장이상 12자 이하면 예외가 발생하지않는다")
    @Test
    void validatePasswordTest() {
        assertThatCode(()->PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "abcdabcdabcda"})
    void validatePasswordTest2(String password) {
        System.out.println("테스트할 비밀번호: " + password); // 🔍 디버깅

        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Password must be between");
    }
}
