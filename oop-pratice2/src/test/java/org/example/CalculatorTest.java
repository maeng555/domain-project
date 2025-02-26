package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    /**
    @DisplayName("덧셈을 정상적으로 수행한다 ")
    @Test
    void addtionTest() {
        int result = Calculator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈을 수행한다")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(1, "-", 2);
        assertThat(result).isEqualTo(-1);
    }
    **/
    @DisplayName("덧셈을 정상적으로 수행한다 ")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(operand1, operator, operand2);
        assertThat(calculateResult).isEqualTo(result);
    }
    public static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                Arguments.of(1, "+", 2, 3),
                Arguments.of(1, "-", 2, -1),
                Arguments.of(1, "*", 2, 2),
                Arguments.of(4, "/", 2, 2)
        );
    }

}
