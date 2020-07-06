package com.hiscat.ds.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void print() {
        Maze.of(8, 8).print();
    }

    @Test
    void testWalk() {
        Maze maze = Maze.of(9, 9);
        assertTrue(maze.walk());
        maze.print();
//        maze.reset();
//        maze.print();
        maze.printStep();
    }
}