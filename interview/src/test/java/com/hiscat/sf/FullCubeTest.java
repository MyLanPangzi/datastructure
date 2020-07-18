package com.hiscat.sf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullCubeTest {

    @Test
    void isCube() {
        assertTrue(FullCube.isCube(6, 4));
        assertFalse(FullCube.isCube(100, 1));
    }
}