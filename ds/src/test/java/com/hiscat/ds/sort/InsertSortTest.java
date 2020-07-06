package com.hiscat.ds.sort;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void sort() {
        int[] arr = {3, 2, 4, 1, 5};
        InsertSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(arr));
    }
    @Test
    void testSort() {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        System.out.println(LocalDateTime.now());
        InsertSort.sort(arr);
        System.out.println(LocalDateTime.now());
    }

}