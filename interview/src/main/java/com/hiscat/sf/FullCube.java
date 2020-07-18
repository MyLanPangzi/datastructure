package com.hiscat.sf;

/**
 * @author hiscat
 */
public class FullCube {
    public static boolean isCube(int a, int b) {

        return Math.pow(b, 3) == Double.parseDouble(a + "" + b);
    }
}
