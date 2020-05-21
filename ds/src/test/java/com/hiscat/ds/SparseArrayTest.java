package com.hiscat.ds;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SparseArrayTest {

    @Test
    void testMakeBinaryArray() {
        //arr[1]][2]=1
        //arr[2]][3]=2
        int[][] arr = SparseArray.makeBinaryArray(11, 11);
        assertEquals(1, arr[1][2]);
        assertEquals(2, arr[2][3]);
    }

    @Test
    void testMakeSparseArray() {
        //arr[1]][2]=1
        //arr[2]][3]=2
        int[][] binaryArray = SparseArray.makeBinaryArray(11, 11);
        int[][] sparseArray = SparseArray.makeSparseArray(binaryArray);
        assertEquals(11, sparseArray[0][0]);
        assertEquals(11, sparseArray[0][1]);
        assertEquals(2, sparseArray[0][2]);

        assertEquals(1, sparseArray[1][0]);
        assertEquals(2, sparseArray[1][1]);
        assertEquals(1, sparseArray[1][2]);

        assertEquals(2, sparseArray[2][0]);
        assertEquals(3, sparseArray[2][1]);
        assertEquals(2, sparseArray[2][2]);
    }

    @Test
    void testRestoreBinaryArray() {
        //arr[1]][2]=1
        //arr[2]][3]=2
        int[][] binaryArray = SparseArray.makeBinaryArray(11, 11);
        int[][] sparseArray = SparseArray.makeSparseArray(binaryArray);
        int[][] restoreArray = SparseArray.restoreArray(sparseArray);

        assertEquals(1, restoreArray[1][2]);
        assertEquals(2, restoreArray[2][3]);
    }

    @Test
    void testWrite2Disk() throws IOException {
        int[][] sparseArray = SparseArray.makeSparseArray(SparseArray.makeBinaryArray(11, 11));
        String path = "E:\\github\\datastructure\\ds\\src\\main\\resources\\sparse.txt";
        SparseArray.printSparseArray(sparseArray, path);
    }

    @Test
    void testReadSparseArray() throws IOException {
        //arr[1]][2]=1
        //arr[2]][3]=2
        int[][] sparseArray = SparseArray.makeSparseArray(SparseArray.makeBinaryArray(11, 11));
        String path = "E:\\github\\datastructure\\ds\\src\\main\\resources\\sparse.txt";
        SparseArray.printSparseArray(sparseArray, path);
        int[][] restoreArray = SparseArray.readSparseArray(path);

        assertEquals(11, restoreArray[0][0]);
        assertEquals(11, restoreArray[0][1]);
        assertEquals(2, restoreArray[0][2]);

        assertEquals(1, restoreArray[1][0]);
        assertEquals(2, restoreArray[1][1]);
        assertEquals(1, restoreArray[1][2]);

        assertEquals(2, restoreArray[2][0]);
        assertEquals(3, restoreArray[2][1]);
        assertEquals(2, restoreArray[2][2]);

    }

}