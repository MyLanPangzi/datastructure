package com.hiscat.ds.sort;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest {

    @Test
    void testPrint() {
        int[] arr = {6, 5, 4, 3, 2, 1};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void sort() {
        int[] arr = {3, 2, 1, 5, 4};
        ShellSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testSort() {
        int[] arr = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000000);
        }
        System.out.println(LocalDateTime.now());
        ShellSort.sort(arr);
        System.out.println(LocalDateTime.now());
    }
}