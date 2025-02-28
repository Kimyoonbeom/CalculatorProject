package calculatorLevel3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // ArithmeticCalculator 인스턴스 만들기.
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        // 입력을 위한 Scanner 생성.
        Scanner scanner = new Scanner(System.in);

        while (true){
            // 첫 번째 숫자 입력하기.
            System.out.println("첫 번째 숫자를 입력하세요 (종료하려면 'exit'를 입력): ");
            String input = scanner.nextLine();
            // exit를 입력시 종료
            if (input.equals("exit")){
                break;
            }
            // exit를 잘못적어서 다른 문자열을 입력했을때
            try{
                double num1 = Double.parseDouble(input);
            } catch (NumberFormatException exception){
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }
            // 입력받은 문자열을 double로 변환
            double num1 = Double.parseDouble(input);

            // 두 번째 숫자 입력 요청
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            // 연산자 입력 요청
            System.out.println("연산자를 입력하세요 (+, -, *, /): ");
            String operator = scanner.nextLine();

            try{
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: "+ result);
                // 모든 계산 결과 출력
                System.out.println("모든 결과:" + calculator.getResults());

                // 기준값 입력
                System.out.println("기준값을 입력하세요: ");
                double threshold = Double.parseDouble(scanner.nextLine());

                // 기준값보다 큰 결과 출력
                System.out.println(threshold + "보다 큰 결과 출력:");
                calculator.printResultsGreaterThan(threshold);
                } catch (IllegalArgumentException | ArithmeticException exception){
                // 예외 발생 시 처리
                System.out.println("오류: "+ exception.getMessage());
            }
        }


    }
}
