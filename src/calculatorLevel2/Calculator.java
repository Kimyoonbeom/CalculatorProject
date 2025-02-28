package calculatorLevel2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private List<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, char operator) {
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(List<Double> results) {
        this.results = new ArrayList<>(results);
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);  // 가장 먼저 저장된 데이터(인덱스 0) 삭제
        }
    }
}
