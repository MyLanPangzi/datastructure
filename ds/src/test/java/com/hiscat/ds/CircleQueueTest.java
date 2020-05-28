package com.hiscat.ds;

import com.hiscat.ds.queue.CircleQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleQueueTest {

    @Test
    void isEmpty() {
        assertTrue(new CircleQueue(1).isEmpty());
    }

    @Test
    void isFull() {
        CircleQueue circleQueue = new CircleQueue(1);
        assertFalse(circleQueue.isFull());
        circleQueue.put(1);
        assertTrue(circleQueue.isFull());
    }

    @Test
    void put() {
        assertTrue(new CircleQueue(1).put(1));
    }

    @Test
    void take() {
        CircleQueue circleQueue = new CircleQueue(2);
        assertTrue(circleQueue.put(1));
        assertTrue(circleQueue.put(2));
        assertEquals(1, circleQueue.take());
        assertTrue(circleQueue.put(1));
        assertEquals(2, circleQueue.take());
        assertEquals(1, circleQueue.take());
    }

    @Test
    void peek() {
        CircleQueue circleQueue = new CircleQueue(2);
        assertTrue(circleQueue.put(1));
        assertTrue(circleQueue.put(2));
        assertEquals(1, circleQueue.peek());
        assertEquals(1, circleQueue.take());
        assertEquals(2, circleQueue.take());
        assertTrue(circleQueue.put(1));
        assertEquals(1, circleQueue.peek());
    }

    @Test
    void show() {
        CircleQueue circleQueue = new CircleQueue(2);
        circleQueue.put(1);
        circleQueue.put(2);
        circleQueue.show();
    }

    @Test
    void size() {
        CircleQueue circleQueue = new CircleQueue(2);
        circleQueue.put(1);
        assertEquals(1, circleQueue.size());
        circleQueue.put(2);
        assertEquals(2, circleQueue.size());
    }
}