package com.hiscat.ds.sort;

/**
 * @author hiscat
 */
public class SelectSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            if (k == i) {
                continue;
            }
            int tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }
    }
}
