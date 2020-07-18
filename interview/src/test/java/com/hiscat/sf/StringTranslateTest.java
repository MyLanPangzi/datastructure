package com.hiscat.sf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTranslateTest {

    @Test
    void canTranslate() {
        assertTrue(StringTranslate.canTranslate("abbcaa",""));
    }
}