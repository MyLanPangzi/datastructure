package com.hiscat.ds.sort;

import java.util.Arrays;

/**
 * @author hiscat
 */
public class ShellSort {
    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                //移位法，效率高
                while (j >= gap && arr[j] < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = tmp;
//                for (int j = i; j >= gap; j -= gap) { //交换法，效率低
//                    if (arr[j] < arr[j - gap]) {
//                        int tmp = arr[j];
//                        arr[j] = arr[j - gap];
//                        arr[j - gap] = tmp;
//                    }
//                }
            }
        }
    }
}
