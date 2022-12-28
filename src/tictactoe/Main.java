package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ticTacToe = """
                X O X
                O X O
                X X O\s""";
        //System.out.println(ticTacToe);
        char[][] matrix = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.contains("X") || input.contains("_") || input.contains("O")) {
            for (int i = 0; i < input.length(); i++) {
                System.out.print("-");
            }
            System.out.println();
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == 0) {
                        matrix[i][j] = input.charAt(j);
                        System.out.print(matrix[i][j] + " ");
                    }
                    else if (i == 1) {
                        matrix[i][j] = input.charAt(j+3);
                        System.out.print(matrix[i][j] + " ");
                    } else {
                        matrix[i][j] = input.charAt(j+6);
                        System.out.print(matrix[i][j] + " ");
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            for (int i = 0; i < input.length(); i++) {
                System.out.print("-");
            }
        }
        System.out.println();
        boolean doesXwin = false;
        boolean doesOwin = false;
        boolean isDraw = false;
        boolean isImpossible = false;
        boolean isFinished = false;
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'X') {
                    counterX++;
                }
                if (matrix[i][j] == 'O') {
                    counterO++;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!isFinished && (!doesXwin && !doesOwin)) {
                    isDraw = true;
                }
                if ((matrix[0][j] == 'X' && matrix[1][j] == 'X' && matrix[2][j] == 'X') ||
                        (matrix[i][0] == 'X' && matrix[i][1] == 'X' && matrix[i][2] == 'X') ||
                        (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') ||
                        (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X'))
                {
                            doesXwin = true;
                            isDraw = false;
                            isFinished = false;
                }
                else if ((matrix[0][j] == 'O' && matrix[1][j] == 'O' && matrix[2][j] == 'O') ||
                        (matrix[i][0] == 'O' && matrix[i][1] == 'O' && matrix[i][2] == 'O') ||
                        (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') ||
                        (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O'))
                {
                    doesOwin = true;
                    isDraw = false;
                    isFinished = false;
                }
                else if (matrix[i][j] == '_' && (Math.abs(counterX - counterO) < 2) && (!doesXwin && !doesOwin)) {
                    isFinished = true;
                }

                else if ((doesOwin && doesXwin) || (Math.abs(counterX - counterO ) >= 2)) {
                    isImpossible = true;
                }
            }
        }
        if (isFinished ) {//&& !isImpossible
            System.out.println("Game not finished");
        }
        if (doesXwin && !doesOwin) {
            System.out.println("X wins");
        }
        if (doesOwin && !doesXwin) {
            System.out.println("O wins");
        }
        if (isDraw && !isFinished && !isImpossible) {
            System.out.println("Draw");
        }
        if (isImpossible) {
            System.out.println("Impossible");
        }
    }
}
