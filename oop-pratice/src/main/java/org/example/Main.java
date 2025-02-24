package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("🚀 테스트 1: abcdefg (7자)");
            PasswordValidator.validate("abcdefg");  // 7자 → 예외 발생해야 함
        } catch (IllegalArgumentException e) {
            System.out.println("✅ 예외 발생 1: " + e.getMessage());
        }

        try {
            System.out.println("\n🚀 테스트 2: abcdabcdabcd (13자)");
            PasswordValidator.validate("abcdabcdabcda");  // 13자 → 예외 발생해야 함
        } catch (IllegalArgumentException e) {
            System.out.println("✅ 예외 발생 2: " + e.getMessage());
        }
    }
}