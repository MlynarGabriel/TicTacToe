package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!board.isFull() && !hasWinner()) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("column (1-3): ");
            int col = scanner.nextInt() - 1;
            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Current Player: " + currentPlayer.getMarker());
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    return;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("This cell is already occupied. Try again.");
            }
        }
        board.print();
        System.out.println("It's a draw!");
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((Board.getCell(i, 0) == marker && Board.getCell(i, 1) == marker && Board.getCell(i, 2) == marker) ||
                    (Board.getCell(0, i) == marker && Board.getCell(1, i) == marker && Board.getCell(2, i) == marker)) {
                return true;
            }
        }
        // Check diagonals
        if ((Board.getCell(0, 0) == marker && Board.getCell(1, 1) == marker && Board.getCell(2, 2) == marker) ||
                (Board.getCell(0, 2) == marker && Board.getCell(1, 1) == marker && Board.getCell(2, 0) == marker)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
