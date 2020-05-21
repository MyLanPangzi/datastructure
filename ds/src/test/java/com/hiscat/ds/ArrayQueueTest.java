package com.hiscat.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void testIsEmpty() {
        assertTrue(new ArrayQueue(10).isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(new ArrayQueue(1).isFull());
    }

    @Test
    void testPut() {
        assertTrue(new ArrayQueue(1).put(1));
    }

    @Test
    void testTake() {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        arrayQueue.put(1);
        arrayQueue.put(2);
        assertEquals(1, arrayQueue.take());
    }

    @Test
    void testPeek() {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        arrayQueue.put(1);
        arrayQueue.put(2);
        assertEquals(1, arrayQueue.peek());
    }

    @Test
    void testShow() {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        arrayQueue.show();
        arrayQueue.put(1);
        arrayQueue.show();
    }

    @Test
    void testSize() {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.put(1);
        assertEquals(1,arrayQueue.size());
    }
}