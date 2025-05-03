package com.example.Lv3;

public enum OperatorType {
    PLUS('+') {
        @Override
        <T extends Number> T calculate(T operand1,T operand2) {
            return calculateByType(operand1, operand2, '+');}
    },
    MINUS('-') {
        @Override
        <T extends Number> T calculate(T operand1,T operand2) {
            return calculateByType(operand1, operand2,'-');}
    },
    MULTIPLY('*') {
        @Override
        <T extends Number> T calculate(T operand1,T operand2) {
            return calculateByType(operand1, operand2,'*');}
    },
    DIVIDE('/') {
        @Override
        <T extends Number> T calculate(T operand1,T operand2) {
            return calculateByType(operand1, operand2,'/'); }
    };

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }
    public char getOperator() {
        return operator;
    }
    public static OperatorType translateOperator(char charOperator) {
        OperatorType[] Operators = OperatorType.values();
        for(int i = 0; i < Operators.length; i++) {
            if(Operators[i].getOperator() == charOperator)
                return Operators[i];
        }
        throw new IllegalArgumentException(String.format("+,-,*,/ 외의 연산자가 입력되었습니다."));
    }
        abstract <T extends Number> T calculate(T operand1, T operand2);

        //generic하게 구현은 했으나, main에서 generic의 의미를 살리지 못하는 듯하다.
        static <T extends Number> T calculateByType(T operand1, T operand2, char operator) {
            if(operand1 instanceof Integer) {
                int op1 = operand1.intValue();
                int op2 = operand2.intValue();
                int result = 0;
                switch(operator) {
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        result = op1 / op2;
                        break;
                }
                return (T)Integer.valueOf(result);
            }
            else if(operand1 instanceof Double) {
                double op1 = operand1.doubleValue();
                double op2 = operand2.doubleValue();
                double result = 0.0;
                switch(operator) {
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        result = op1 / op2;
                        break;
                }
                return (T)Double.valueOf(result);
            }
            throw new IllegalArgumentException("피연산자의 타입이 잘못되었습니다.");
        }
}
