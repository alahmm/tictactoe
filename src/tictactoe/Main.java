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
    public static boolean checkForValue(char val, char [][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == val) return true;
            }
        }
        return false; //it will reach here if return true was not called.
    }

    public static void main(String[] args) {
        boolean doesXwin = false;
        boolean doesOwin = false;
        boolean isDraw = false;
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
                counterX++;
            } else {
                matrix[Integer.parseInt(i) - 1][Integer.parseInt(j) - 1] = 'O';
                ShowMatrix(matrix);
                counterO++;
            }
            if ((matrix[0][Integer.parseInt(j) - 1] == 'X' && matrix[1][Integer.parseInt(j) - 1] == 'X' && matrix[2][Integer.parseInt(j) - 1] == 'X') ||
                    (matrix[Integer.parseInt(i) - 1][0] == 'X' && matrix[Integer.parseInt(i) - 1][1] == 'X' && matrix[Integer.parseInt(i) - 1][2] == 'X') ||
                    (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') ||
                    (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X')) {
                doesXwin = true;
                break;
            } else if ((matrix[0][Integer.parseInt(j) - 1] == 'O' && matrix[1][Integer.parseInt(j) - 1] == 'O' && matrix[2][Integer.parseInt(j) - 1] == 'O') ||
                    (matrix[Integer.parseInt(i) - 1][0] == 'O' && matrix[Integer.parseInt(i) - 1][1] == 'O' && matrix[Integer.parseInt(i) - 1][2] == 'O') ||
                    (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') ||
                    (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O')) {
                doesOwin = true;
                break;
            }else if (!checkForValue('_',matrix)) {
                    isDraw = true;
                    break;
            }
        }

            if (doesXwin) {
                System.out.println("X wins");
            }
            if (doesOwin) {
                System.out.println("O wins");
            }
            if (isDraw) {
                System.out.println("Draw");
            }
    }
}
