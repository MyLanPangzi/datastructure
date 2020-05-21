package com.hiscat.ds;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author hiscat
 */
public class SparseArray {
    public static int[][] makeBinaryArray(int row, int col) {
        int[][] result = new int[row][col];
        result[1][2] = 1;
        result[2][3] = 2;
        return result;
    }

    public static int[][] makeSparseArray(int[][] binaryArray) {
        //1. 遍历原始数组得到有效元素个数：elementCount
        //2. 根据elementCount生成sparseArray[elementCount]\[3]
        //3. 遍历原始数组，记录有效行列及值
        return makeSparseArray(binaryArray, getElementCount(binaryArray));
    }

    private static int getElementCount(int[][] binaryArray) {
        int elementCount = 0;
        for (int[] row : binaryArray) {
            for (int col : row) {
                if (col != 0) {
                    elementCount++;
                }
            }
        }
        return elementCount;
    }

    private static int[][] makeSparseArray(int[][] binaryArray, int elementCount) {
        int[][] sparseArray = new int[elementCount + 1][3];
        sparseArray[0][0] = binaryArray.length;
        sparseArray[0][1] = binaryArray[0].length;
        sparseArray[0][2] = elementCount;

        fillSparseArray(binaryArray, sparseArray);
        return sparseArray;
    }

    private static void fillSparseArray(int[][] binaryArray, int[][] sparseArray) {
        int sparseArrayRow = 1;
        for (int row = 0; row < binaryArray.length; row++) {
            for (int col = 0; col < binaryArray[row].length; col++) {
                if (binaryArray[row][col] != 0) {
                    sparseArray[sparseArrayRow][0] = row;
                    sparseArray[sparseArrayRow][1] = col;
                    sparseArray[sparseArrayRow][2] = binaryArray[row][col];
                    sparseArrayRow++;
                }
            }
        }
    }

    public static int[][] restoreArray(int[][] sparseArray) {
        //1. 从sparseArray取出原始数组行列及元素个数，row=sparseArray[0][0]，col=sparseArray[0][1]
        //2. 构造原始数组
        //3. 迭代稀疏矩阵，为原始数组填充数据
        int binaryArrayRows = sparseArray[0][0];
        int binaryArrayCols = sparseArray[0][1];
        int[][] binaryArray = new int[binaryArrayRows][binaryArrayCols];
        for (int sparseArrayRow = 1; sparseArrayRow < sparseArray.length; sparseArrayRow++) {
            int row = sparseArray[sparseArrayRow][0];
            int col = sparseArray[sparseArrayRow][1];
            int val = sparseArray[sparseArrayRow][2];
            binaryArray[row][col] = val;
        }
        return binaryArray;
    }

    static void printSparseArray(int[][] sparseArray, String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             PrintStream printStream = new PrintStream(bufferedOutputStream)) {
            for (int[] rows : sparseArray) {
                printStream.printf("%d\t%d\t%d\t\n", rows[0], rows[1], rows[2]);
            }
            printStream.flush();
        }
    }

    public static int[][] readSparseArray(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        int[][] sparseArray = new int[lines.size()][3];
        for (int row = 0; row < lines.size(); row++) {
            String[] split = lines.get(row).split("\t");
            sparseArray[row][0] = Integer.parseInt(split[0]);
            sparseArray[row][1] = Integer.parseInt(split[1]);
            sparseArray[row][2] = Integer.parseInt(split[2]);
        }
        return sparseArray;
    }
}
