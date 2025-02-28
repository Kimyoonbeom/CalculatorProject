package calculatorLevel3;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    // 계산 결과를 저장.
    private final List<Double> results = new ArrayList<>();

    // 계산 수행 메서드
    public Double calculate(T num1, T num2, String operator) {
        // 문자열로부터 Operator 객체를 생성.
        OperatorType opType = OperatorType.fromSymbol(operator);
        // 계산.
        Double result = opType.apply(num1.doubleValue(), num2.doubleValue());
        // 결과를 리스트에 추가 및 결과 반환.
        results.add(result);
        return result;
    }
    // 모든 계산 반환.
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }
    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
    public void printResultsGreaterThan(Double threshold) {
        // 리스트를 스트림으로 변환하기.
        results.stream()
                // 필터링(입력값보다 큰 결과값만 나오게 하기)
                .filter(result -> result > threshold)
                // 결과 출력.
                .forEach(System.out::println);
    }
}

