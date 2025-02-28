package calculatorLevel2;
import java.util.Scanner; //입력 import
public class App {
// calculator 객체를 저장하기 위한 필드
    private Calculator calculator;
// 이거는 메인의 App app = new App(calculator); 로 표시하려고 할때
    public App(Calculator calculator) {
        // 전달 받은 calculator 객체를 필드에 저장.
        this.calculator = calculator;
    }
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        /* 반복문 시작 */
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 (종료하려면 'exit' 입력): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int num1 = Integer.parseInt(input); //첫번째 숫자 변환.

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = Integer.parseInt(sc.nextLine());

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.nextLine().charAt(0);

            try {
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("연산 결과 = " + result);

                System.out.println("현재 저장된 모든 결과: " + calculator.getResults());

                // 가장 먼저 저장된 결과 삭제
                calculator.removeResult();
                System.out.println("첫 번째 결과 삭제 후: " + calculator.getResults());
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (계속하려면 아무 키나, 종료하려면 'exit' 입력)");
            if (sc.nextLine().equalsIgnoreCase("exit")) {
                break;
            }
        }
        /* 반복문 종료 */
        sc.close();
    }

    public void run() {
        // Main의 프로그램 실행 'run'을 위한 {}
    }
}
