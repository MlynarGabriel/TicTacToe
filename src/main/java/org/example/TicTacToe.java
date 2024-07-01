package org.example;

import java.util.InputMismatchException;
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

        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            int row = getValidInput("row");
            int col = getValidInput("column");

            if (board.isCellEmpty(row - 1, col - 1)) {
                board.place(row - 1, col - 1, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.print();
                    System.out.println("The game is a draw!");
                    break;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is already occupied. Please choose another cell.");
            }
        }
    }

    // Getter für Tests
    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        return (checkRow() || checkColumn() || checkDiagonal());
    }

    private boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) != ' ' &&
                    board.getCell(i, 0) == board.getCell(i, 1) &&
                    board.getCell(i, 1) == board.getCell(i, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(0, i) != ' ' &&
                    board.getCell(0, i) == board.getCell(1, i) &&
                    board.getCell(1, i) == board.getCell(2, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        if (board.getCell(0, 0) != ' ' &&
                board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 2)) {
            return true;
        }
        if (board.getCell(0, 2) != ' ' &&
                board.getCell(0, 2) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 0)) {
            return true;
        }
        return false;
    }

    // Methode für Benutzereingaben für das Startspiel
    public int getValidInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while (input < 1 || input > 3) {
            System.out.print(prompt + " (1-3): ");
            try {
                input = scanner.nextInt();
                if (input < 1 || input > 3) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next();  // Clear the invalid input
            }
        }
        return input;
    }
}
