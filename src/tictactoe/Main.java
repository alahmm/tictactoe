package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void ShowMatrix(char[][] matrix) {
            for (int i = 0; i < 10; i++) {
                System.out.print("-");
            }
            System.out.println();
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == 0) {
                        if (matrix[i][j] == 'X' || matrix[i][j] == 'O') {
                            System.out.print(matrix[i][j] + " ");
                        } else {
                            matrix[i][j] = '_';
                            System.out.print(matrix[i][j] + " ");
                        }
                    } else if (i == 1) {
                        if (matrix[i][j] == 'X' || matrix[i][j] == 'O') {
                            System.out.print(matrix[i][j] + " ");
                        } else {
                            matrix[i][j] = '_';
                            System.out.print(matrix[i][j] + " ");
                        }
                    } else {
                        if (matrix[i][j] == 'X' || matrix[i][j] == 'O') {
                            System.out.print(matrix[i][j] + " ");
                        } else {
                            matrix[i][j] = '_';
                            System.out.print(matrix[i][j] + " ");
                        }
                    }
                }
                System.out.print("|");
                System.out.println();
            }
            for (int i = 0; i < 10; i++) {
                System.out.print("-");
            }
        System.out.println();
        }
        public static void ShowStatus (char[][] matrix) {
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
/*            if (isFinished ) {//&& !isImpossible
                System.out.println("Game not finished");
            }*/
            if (doesXwin && !doesOwin) {
                System.out.println("X wins");
                return;
            }
            if (doesOwin && !doesXwin) {
                System.out.println("O wins");
                return;
            }
            if (isDraw && !isFinished && !isImpossible) {
                System.out.println("Draw");
                return;
            }
/*            if (isImpossible) {
                System.out.println("Impossible");
            }*/
        }

    public static void main(String[] args) {
        int counterX = 0;
        int counterO = 0;
        char[][] matrix = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        ShowMatrix(matrix);
        while (true) {
            String i = scanner.next();
            String j = scanner.next();
            if (!i.matches("\\d+")) {
                System.out.println("You should enter numbers!");
            } else if (Integer.parseInt(i) > 3 || Integer.parseInt(i) < 1 || Integer.parseInt(j) > 3 || Integer.parseInt(j) < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] == 'X' ||
                    matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (counterO == counterX) {
                matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] = 'X';
                ShowMatrix(matrix);
                ShowStatus(matrix);
                counterX++;
            } else {
                matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] = 'O';
                ShowMatrix(matrix);
                ShowStatus(matrix);
                counterO++;
            }
/*            if (!doesXwin && !doesOwin && matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] != '_') {
                isDraw = true;
            } else if ((matrix[0][Integer.parseInt(j) - 1] == 'X' && matrix[1][Integer.parseInt(j) - 1] == 'X' && matrix[2][Integer.parseInt(j) - 1] == 'X') ||
                    (matrix[Integer.parseInt(i) - 1][0] == 'X' && matrix[Integer.parseInt(i) - 1][1] == 'X' && matrix[Integer.parseInt(i) - 1][2] == 'X') ||
                    (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') ||
                    (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X'))
            {
                doesXwin = true;
                isDraw = false;
                return;
            } else if ((matrix[0][Integer.parseInt(j) - 1] == 'O' && matrix[1][Integer.parseInt(j) - 1] == 'O' && matrix[2][Integer.parseInt(j) - 1] == 'O') ||
                    (matrix[Integer.parseInt(i) - 1][0] == 'O' && matrix[Integer.parseInt(i) - 1][1] == 'O' && matrix[Integer.parseInt(i) - 1][2] == 'O') ||
                    (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') ||
                    (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O'))
            {
                doesOwin = true;
                isDraw = false;
                return;
            }*/
        }
/*        if (doesXwin && !doesOwin) {
            System.out.println("X wins");
        }
        if (doesOwin && !doesXwin) {
            System.out.println("O wins");
        }
        if (isDraw) {
            System.out.println("Draw");
        }*/
    }

}

