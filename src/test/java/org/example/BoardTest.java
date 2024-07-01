package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmptyWhenCellIsEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmptyWhenCellIsNotEmpty() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceCellSuccessfully() {
        board.place(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1));
    }

    @Test
    public void testPlaceCellWhenCellIsNotEmpty() {
        board.place(2, 2, 'X');
        board.place(2, 2, 'O');  // Trying to place a marker on an occupied cell
        assertEquals('X', board.getCell(2, 2));  // Should still be 'X'
    }

    @Test
    public void testIsFullWhenBoardIsFull() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'X');
        board.place(2, 1, 'O');
        board.place(2, 2, 'X');
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFullWhenBoardIsNotFull() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }

    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }
}
