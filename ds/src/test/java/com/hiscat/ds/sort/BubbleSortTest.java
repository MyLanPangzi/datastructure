package com.hiscat.ds.sort;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        int[] arr = {3, 2, 1, 5, 4};
        BubbleSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testSort() {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        System.out.println(LocalDateTime.now());
        BubbleSort.sort(arr);
        System.out.println(LocalDateTime.now());
    }
}