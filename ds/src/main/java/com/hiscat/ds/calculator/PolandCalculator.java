package com.hiscat.ds.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author hiscat
 */
public class PolandCalculator {
    private Stack<Integer> stack;
    private List<String> elements;

    public PolandCalculator(String expression) {
        stack = new Stack<>();
        elements = Arrays.asList(expression.trim().split(" "));
    }

    public Integer getResult() {
        for (String element : elements) {
            if (element.matches("\\d+")) {
                int i = Integer.parseInt(element);
                stack.push(i);
            } else {
                calc(element);
            }
        }

        return stack.pop();
    }

    private void calc(String element) {
        Integer a = stack.pop();
        Integer b = stack.pop();
        System.out.printf("%d %s %d \n", b, element, a);
        switch (element) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(b - a);
                break;
            case "*":
                stack.push(b * a);
                break;
            case "/":
                stack.push(b / a);
                break;
            default:
                break;
        }
    }
}
