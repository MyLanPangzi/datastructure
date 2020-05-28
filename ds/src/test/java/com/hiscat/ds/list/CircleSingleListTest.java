package com.hiscat.ds.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
class CircleSingleListTest {

    @Test
    void show() {
        CircleSingleList.make(3).show();
    }

    @Test
    void testPlay() {
        CircleSingleList.make(5).play(2, 2);
    }
}