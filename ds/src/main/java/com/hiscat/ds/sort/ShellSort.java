package com.hiscat.ds.sort;

import java.util.Arrays;

/**
 * @author hiscat
 */
public class ShellSort {
    public static void sort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }
            gap /= 2;
        }

    }
}
