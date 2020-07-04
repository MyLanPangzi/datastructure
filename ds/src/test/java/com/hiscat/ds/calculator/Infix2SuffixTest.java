package com.hiscat.ds.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Infix2SuffixTest {

    @Test
    void testInfix2Suffix() {
        Infix2Suffix infix2Suffix = new Infix2Suffix("1 - 1 + 1 + ( ( 2 + 3 + 3 - 3 ) * 4 ) - 5 + 10 - 10");
        String result = infix2Suffix.getResult();
        System.out.println(result);
        assertEquals(16, new PolandCalculator(result).getResult());
    }

}