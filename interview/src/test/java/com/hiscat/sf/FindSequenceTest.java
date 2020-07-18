package com.hiscat.sf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSequenceTest {

    @Test
    void hasTwoSequence() {
        assertTrue(FindSequence.hasTwoSequence(new int[]{1, 2, 5, 3, 4, 1, 2}));
        assertFalse(FindSequence.hasTwoSequence(new int[]{1, 2, 5, 3, 4, 1, 1}));
    }
}