package com.hiscat.ds.stack;

import com.hiscat.ds.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getResult() {
        Calculator calculator = new Calculator("1+2*3-2");
        assertEquals(5, calculator.getResult());
    }
}