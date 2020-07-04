package com.hiscat.ds.stack;

/**
 * @author hiscat
 */
public class Calculator {
    private String expression;
    private ArrayStack operatorStack;
    private ArrayStack numberStack;

    public Calculator(String expression) {
        this.expression = expression;
        this.operatorStack = new ArrayStack(100);
        this.numberStack = new ArrayStack(100);
    }

    public int getResult() {
        System.out.println(expression);
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.substring(i, i + 1).charAt(0);
            if (Character.isDigit(ch)) {
                numberStack.push(ch - 48);
            } else if (isOperator(ch)) {
                if (!operatorStack.isEmpty() && currentIsLowPriority(ch)) {
                    calc();
                }
                operatorStack.push(ch);
            }
        }
        while (!operatorStack.isEmpty()) {
            calc();
        }
        return numberStack.pop();
    }

    private boolean isOperator(char operator) {
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }

    private boolean currentIsLowPriority(char ch) {
        return getPriority(operatorStack.peek()) >= getPriority(ch);
    }

    private int getPriority(int operator) {
        switch (operator) {
            case '/':
            case '*':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    private void calc() {
        int n = numberStack.pop();
        int m = numberStack.pop();
        int o = operatorStack.pop();
        int calc1 = calc(n, m, o);
        System.out.printf("%d %c %d = %d\n", m, o, n, calc1);
        numberStack.push(calc1);
    }

    private int calc(int num1, int num2, int operator) {
        switch (operator) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return Integer.MAX_VALUE;
        }
    }

}
