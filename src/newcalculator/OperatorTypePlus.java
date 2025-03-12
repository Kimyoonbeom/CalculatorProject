package newcalculator;

import java.util.Arrays;

public enum OperatorTypePlus {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    }),
    SQRT("sqrt", (a, b) -> Math.sqrt(a)),  // 제곱근 추가
    LOG("log", (a, b) -> Math.log(a));     // 로그 추가

    private final String symbol;
    private final Operation operation;

    OperatorTypePlus(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public double apply(double a, double b) {
        return operation.execute(a, b);
    }

    public static OperatorTypePlus fromSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 연산자: " + symbol));
    }

    @FunctionalInterface
    private interface Operation {
        double execute(double a, double b);
    }
}

