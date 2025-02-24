package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },SUBTRACTION("-"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },MULTIPLICATION("*"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },DIVISION("/"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public abstract int ArithmeticCalculate(int operand1, int operand2);
    public static int calculate(int operand1, String operator, int operand2) {
        //stream values로 모든 enum 값을 가져옴
        ArithmeticOperator arithmeticOperator = Arrays.stream(ArithmeticOperator.values())
                .filter(v->v.operator.equals(operator))//같은게잇으면가져온다
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        return arithmeticOperator.ArithmeticCalculate(operand1,operand2);
    }
}
