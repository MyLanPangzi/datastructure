package com.hiscat.ds.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void printResult() {
        Queen queen = new Queen();
        queen.printResult();
        queen.printCount();
        System.out.println(queen.result.size());
    }
}