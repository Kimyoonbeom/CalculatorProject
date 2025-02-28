package calculatorLevel3;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorTypeEx {
    // enum으로 연산자 정의, 람다로 적기.
    plus("+", (a, b) -> a + b),
    minus("-", (a,b) -> a - b),
    multiply("*", (a,b) -> a * b),
    divide("/", (a,b) -> a / b);

    // 연산자 심볼 저장 필드.
    private final String symbol;

    // 실제 연산 수행 필드.
    private final BiFunction<Double, Double, Double> operation;

    // enum 생성자
    OperatorTypeEx(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // getter
    public String getSymbol() {
        return symbol;
    }

    // 연산 수행 메서드
    public Double apply(Double a, Double b) {
        return operation.apply(a,b);
    }

    // 문자열로부터 OperatorType을 찾아 반환하는 메서드
    public static OperatorTypeEx fromOperator(String symbol) {
        return Arrays.stream(values()).filter(op ->op.getSymbol().equals(symbol))
                .findFirst().orElse(null);
    }
}
