package calculatorLevel1;

import java.util.Scanner;

public class CalculatorEx {
    Scanner sc = new Scanner(System.in);
    private String input1;
    int num1 = getPositiveInt(input1, sc);
    int num2 = getPositiveIntPrompt(sc, "두 번째 양의 정수 입력: ");
    char operator = getOperator(sc);

    private static int getPositiveInt(String input, Scanner sc) {
        while (true) {
            try {
                int num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.println("양의 정수만 입력 가능합니다.");
                    input = sc.nextLine().trim();
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 제대로 입력해주세요.");
                input = sc.nextLine().trim();
            }
        }
    }

    private static int getPositiveIntPrompt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.println("양의 정수만 입력 가능합니다.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 제대로 입력해주세요.");
            }
        }
    }

    private static char getOperator(Scanner sc) {
        while (true) {
            System.out.print("연산자 입력 ('+', '-', '*', '/'): ");
            String input = sc.nextLine().trim();
            if (input.length() != 1) {
                System.out.println("연산자는 +, -, *, / 중 하나만 입력해주세요.");
                continue;
            }

            char op = input.charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                return op;
            }

            System.out.println("올바른 연산자가 아닙니다.");
        }
    }
}
