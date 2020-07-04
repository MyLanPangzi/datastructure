package com.hiscat.ds.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolandCalculatorTest {

    @Test
    void getResult() {
        PolandCalculator calculator = new PolandCalculator("3 4 + 5 * 6 -");
        assertEquals(29, calculator.getResult());
        PolandCalculator calculator2 = new PolandCalculator("4 5 * 8 - 60 + 8 2 / +");
        assertEquals(76, calculator2.getResult());
    }
}