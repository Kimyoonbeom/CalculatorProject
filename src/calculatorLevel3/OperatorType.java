package calculatorLevel3;
import java.util.Arrays;

public enum OperatorType {
    // enum으로 연산자 정의, 람다로 적기.
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    // 연산자 심볼 저장 필드.
    private final String symbol;
    // 실제 연산 수행 필드.
    private final Operation operation;

    // enum 생성자
    OperatorType(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // 연산자 심볼 getter 메서드
    public String getSymbol() {
        return symbol;
    }

    // 실제 연산을 수행하는 메서드
    public double apply(double a, double b) {
        return operation.execute(a, b);
    }

    // 문자열 심볼로부터 해당하는 OperatorType을 찾아 반환하는 정적 메서드
    public static OperatorType fromSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 연산자: " + symbol));
    }

    // 연산을 수행하는 함수형 인터페이스
    @FunctionalInterface
    private interface Operation{
        double execute(double a, double b);
    }
}

