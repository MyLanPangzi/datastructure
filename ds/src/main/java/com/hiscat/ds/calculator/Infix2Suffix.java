package com.hiscat.ds.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author hiscat
 */
public class Infix2Suffix {
    private Stack<String> operators;
    private Stack<String> nums;
    private final List<String> elements;

    public Infix2Suffix(String expression) {
        elements = Arrays
                .stream(expression.trim().split(" "))
                .filter(e -> !e.isEmpty())
                .collect(toList());
        operators = new Stack<>();
        nums = new Stack<>();
    }

    public String getResult() {
        for (String element : elements) {
            if (element.matches("\\d+")) {
                nums.push(element);
            } else if ("+-*/".contains(element)) {
                //符号栈非空，栈顶元素不是左括号，当前元素优先级低于等于栈顶元素，弹出栈顶至数字栈
                if (!operators.isEmpty() && !"(".equals(operators.peek()) && !isHighPriority(element)) {
                    nums.push(operators.pop());
                }
                operators.push(element);
            } else if ("(".equals(element)) {
                operators.push(element);
            } else if (")".equals(element)) {
                while (!"(".equals(operators.peek())) {
                    nums.push(operators.pop());
                }
                operators.pop();
            } else {
                throw new RuntimeException("没见过得运算符");
            }
        }
        while (!operators.isEmpty()) {
            nums.push(operators.pop());
        }
        return String.join(" ", nums);
    }

    private boolean isHighPriority(String element) {
        return getPriority(element) > getPriority(operators.peek());
    }

    private int getPriority(String element) {
        return "+-".contains(element) ? 0 : "*/".contains(element) ? 1 : Integer.MIN_VALUE;
    }
}
