package com.hiscat.ds.recursion;

/**
 * @author hiscat
 */
public class Maze {

    private int[][] map;
    private int line;
    private int col;
    private int targetLine;
    private int targetCol;
    private int startLine;
    private int startCol;

    public Maze(int line, int col) {
        this.line = line;
        this.col = col;
        this.targetCol = col - 2;
        this.targetLine = line - 2;
        this.startLine = 1;
        this.startCol = 1;
        initMap(line, col);
    }

    private void initMap(int line, int col) {
        map = new int[line][col];
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[line - 1][i] = 1;
        }
        for (int i = 0; i < line; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[4][4] = 1;
        map[3][4] = 1;
        map[2][4] = 1;
    }


    public void print() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    public void reset() {
        for (int i = 1; i < line - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                map[i][j] = 0;
            }
        }
    }

    public static Maze of(int line, int col) {
        return new Maze(line, col);
    }

    public boolean walk() {
        return walk(startLine, startCol);
    }

    /**
     * 方向：下右上左<br>
     * 0表示未走过<br>
     * 1表示墙<br>
     * 2表示已走过<br>
     * 3表示死胡同<br>
     *
     * @param line 起始行
     * @param col  起始列
     * @return 是否能走通
     */
    private boolean walk(int line, int col) {
        if (map[targetLine][targetCol] == 2) {
            return true;
        }
        if (map[line][col] != 0) {
            return false;
        }
        //下右左上
        map[line][col] = 2;
        if (walk(line + 1, col) || walk(line, col + 1) || walk(line, col - 1) || walk(line - 1, col)) {
            return true;
        }
        map[line][col] = 3;
        return false;
    }
}
