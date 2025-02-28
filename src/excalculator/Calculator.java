package excalculator;
//입력 받는거 만들기

import java.util.Scanner;

public class Calculator {
    /*  양의 정수(0 포함)를 입력 받기

        사칙연산 기호(➕,➖,✖️,➗)를 입력 받기.
        적합한 타입으로 선언한 변수에 저장.

        위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여

        연산을 진행한 후 결과값을 출력하기 ex) if나 switch 사용하기, 연산 오류 생각하기

        반복문을 사용하되, 종료를 알려주는 "exit"문자열 전까지 무한으로 계산.

    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("첫 번째 숫자를 입력하시오(종료를 원하면 'exit'를 입력하세요) : ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("계산기 종료!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            try {
                int num1 = Integer.parseInt(input);
                System.out.println("두 번째 숫자를 입력하세요:");
                int num2 = Integer.parseInt(sc.nextLine().trim());

                System.out.println("사칙연산 기호를 입력하세요('+', '-', '*', '/'):");
                char operator = sc.nextLine().charAt(0);

                double result = 0;

                switch (operator) {
                    case '+':
                        result = (double) num1 + num2;
                        break;
                    case '-':
                        result = (double) num1 - num2;
                        break;
                    case '*':
                        result = (double) num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("0으로 나누는 것은 안 됩니다.");
                            continue;
                        }
                        result = (double) num1 / num2;
                        break;
                    default:
                        System.out.println("제대로 된 연산자를 입력해주세요");
                        continue;
                }
                System.out.println("연산 결과 = " + result);

            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("연산자를 입력해주세요.");
            }
        }
        sc.close();
    }
}

