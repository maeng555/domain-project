package org.example;

public class PasswordValidator {
    public static void validate(String password) {
        System.out.println("validate() 실행됨 - 입력값: " + password); // 🔍 디버깅용

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        int length = password.length();
        if (length < 8 || length > 12) {
            System.out.println("예외 발생 조건 만족함! 비밀번호 길이: " + length); // 🔍 디버깅용
            throw new IllegalArgumentException("Password must be between 8 and 12 characters");
        }
    }
}
