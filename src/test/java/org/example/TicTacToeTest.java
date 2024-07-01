package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        Player newPlayer = game.getCurrentPlayer();
        assertNotEquals(initialPlayer, newPlayer);
    }

    @Test
    public void testHasWinnerRow() {
        // Manually configure the board to have a winner on the first row
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerColumn() {
        // Manually configure the board to have a winner on the first column
        game.getBoard().place(0, 0, 'O');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(2, 0, 'O');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonal() {
        // Manually configure the board to have a winner on the main diagonal
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasNoWinner() {
        // Configure the board with no winners
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(2, 2, 'X');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testIsFullWhenBoardIsFull() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(1, 2, 'O');
        game.getBoard().place(2, 0, 'X');
        game.getBoard().place(2, 1, 'O');
        game.getBoard().place(2, 2, 'X');
        assertTrue(game.getBoard().isFull());
    }

    @Test
    public void testIsFullWhenBoardIsNotFull() {
        game.getBoard().place(0, 0, 'X');
        assertFalse(game.getBoard().isFull());
    }
}
