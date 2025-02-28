package excalculator;

import java.util.Scanner;

public class Calcul {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("첫 번째 숫자를 입력하시오(종료를 원하면 'exit'를 입력하세요) : ");
                String input = sc.nextLine().trim();

                // 1. 입력값이 비어 있는지 확인
                if (input.isEmpty()) {
                    // 2. 비어 있다면 사용자에게 다시 입력을 요청
                    System.out.println("숫자를 입력해주세요.");
                    continue;
                }

                if (input.equals("exit")) {
                    System.out.println("계산기 종료!");
                    break;
                }
                int num1 = Integer.parseInt(input);

                System.out.println("두 번째 숫자를 입력하세요:");
                int num2 = Integer.parseInt(sc.nextLine().trim());

                System.out.println("사칙연산 기호를 입력하세요('+', '-', '*', '/'):");
                char operator = sc.nextLine().charAt(0);

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
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
            }
            sc.close();
        }
    }

