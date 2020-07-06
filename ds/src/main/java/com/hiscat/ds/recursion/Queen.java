package com.hiscat.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hiscat
 */
public class Queen {
     List<String> result;
    private int[] answer;
    private int count;

    public Queen() {
        answer = new int[8];
        result = new ArrayList<>(92);
        place(0);
    }

    public void printCount() {
        System.out.println(count);
    }

    private void place(int n) {
        int max = 8;
        if (n == max) {
            result.add(Arrays.toString(answer));
            return;
        }
        for (int i = 0; i < max; i++) {
            answer[n] = i;
            if (placeOk(n)) {
                place(n + 1);
            }
        }
    }

    private boolean placeOk(int n) {
        count++;
        for (int i = 0; i < n; i++) {
            if (answer[i] == answer[n] || Math.abs(i - n) == Math.abs(answer[i] - answer[n])) {
                return false;
            }
        }
        return true;
    }

    public void printResult() {
        result.forEach(System.out::println);
    }
}
