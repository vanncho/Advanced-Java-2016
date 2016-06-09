import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _15_RadioactiveMutantVampireBunnies {
    static char[][] matrix;
    static int radius = 1;
    static List<Integer> rowsCoordinates = new ArrayList<>();
    static List<Integer> colsCoordinates = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int rows = input.nextInt();
        int cols = input.nextInt();

        matrix = new char[rows][cols];
        int personRowPos = 0;
        int personColPos = 0;

        // fill the matrix
        for (int i = 0; i < matrix.length; i++) {
            String line = input.next();

            for (int j = 0; j < matrix[i].length; j++) {
                char currChar = line.charAt(j);

                if (currChar != 'P' && currChar != 'B'){
                    matrix[i][j] = currChar;
                } else if (currChar == 'B'){
                    rowsCoordinates.add(i);
                    colsCoordinates.add(j);
                } else{
                    matrix[i][j] = currChar;
                    personRowPos = i;
                    personColPos = j;
                }
            }
        }

        String movesOrder = input.next();
        int nextRowPos = personRowPos;
        int nextColPos = personColPos;
        boolean wins = false;
        boolean dead = false;

        // process the matrix
        for (int i = 0; i < movesOrder.length(); i++) {
            char currCommand = movesOrder.charAt(i);
            char swap;

            switch (currCommand){
                case 'U':
                    nextRowPos--;

                    if (nextRowPos < 0){
                        wins = true;
                        updateBunniesStatus();
                        break;
                    } else if (matrix[nextRowPos][nextColPos] != '.') {
                        dead = true;
                        updateBunniesStatus();
                        break;
                    }

                    swap = matrix[personRowPos][personColPos];
                    matrix[personRowPos][personColPos] = matrix[nextRowPos][nextColPos];
                    matrix[nextRowPos][nextColPos] = swap;

                    personRowPos = nextRowPos;
                    break;
                case 'R':
                    nextColPos++;

                    if (nextColPos == cols){
                        wins = true;
                        updateBunniesStatus();
                        break;
                    } else if (matrix[nextRowPos][nextColPos] != '.') {
                        dead = true;
                        updateBunniesStatus();
                        break;
                    }

                    swap = matrix[personRowPos][personColPos];
                    matrix[personRowPos][personColPos] = matrix[nextRowPos][nextColPos];
                    matrix[nextRowPos][nextColPos] = swap;

                    personColPos = nextColPos;
                    break;
                case 'D':
                    nextRowPos++;

                    if (nextRowPos == rows){
                        wins = true;
                        updateBunniesStatus();
                        break;
                    } else if (matrix[nextRowPos][nextColPos] != '.') {
                        dead = true;
                        updateBunniesStatus();
                        break;
                    }

                    swap = matrix[personRowPos][personColPos];
                    matrix[personRowPos][personColPos] = matrix[nextRowPos][nextColPos];
                    matrix[nextRowPos][nextColPos] = swap;

                    personRowPos = nextRowPos;
                    break;
                case 'L':
                    nextColPos--;

                    if (nextColPos < 0){
                        wins = true;
                        updateBunniesStatus();
                        break;
                    } else if (matrix[nextRowPos][nextColPos] != '.') {
                        dead = true;
                        updateBunniesStatus();
                        break;
                    }

                    swap = matrix[personRowPos][personColPos];
                    matrix[personRowPos][personColPos] = matrix[nextRowPos][nextColPos];
                    matrix[nextRowPos][nextColPos] = swap;

                    personColPos = nextColPos;
                    break;
            }

            if (dead || wins){
                break;
            }

            updateBunniesStatus();
            //printMatrix();
            //System.out.println();

        }

        if (wins){
            matrix[personRowPos][personColPos] = '.';
            printMatrix();
            System.out.printf("won: %d %d", personRowPos, personColPos);
        } else if (dead){
            matrix[personRowPos][personColPos] = 'B';
            printMatrix();
            System.out.printf("dead: %d %d", nextRowPos, nextColPos);
        }
    }

    private static void updateBunniesStatus() {

        for (int i = 0; i < rowsCoordinates.size(); i++) {

            // up
            for (int j = 0; j < radius; j++) {
                if (rowsCoordinates.get(i) - radius >= 0){
                    matrix[rowsCoordinates.get(i) - radius][colsCoordinates.get(i)] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
            // right
            for (int j = 0; j < radius; j++) {
                if (colsCoordinates.get(i) + radius < matrix[0].length){
                    matrix[rowsCoordinates.get(i)][colsCoordinates.get(i) + radius] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
            // down
            for (int j = 0; j < radius; j++) {
                if (rowsCoordinates.get(i) + radius < matrix.length){
                    matrix[rowsCoordinates.get(i) + radius][colsCoordinates.get(i)] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
            // left
            for (int j = 0; j < radius; j++) {
                if (colsCoordinates.get(i) - radius >= 0){
                    matrix[rowsCoordinates.get(i)][colsCoordinates.get(i) - radius] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
            // left-side-radius
            for (int j = 0; j < radius; j++) {
                if (rowsCoordinates.get(i) - radius >= 0 && colsCoordinates.get(i) - radius >= 0){
                    matrix[rowsCoordinates.get(i) - radius][colsCoordinates.get(i) - radius] = 'B';
                }
                if (rowsCoordinates.get(i) + radius < matrix.length && colsCoordinates.get(i) - radius >= 0){
                    matrix[rowsCoordinates.get(i) + radius][colsCoordinates.get(i) - radius] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
            // right-side-radius
            for (int j = 0; j < radius; j++) {
                if (rowsCoordinates.get(i) - radius >= 0 && colsCoordinates.get(i) + radius < matrix[0].length){
                    matrix[rowsCoordinates.get(i) - radius][colsCoordinates.get(i) + radius] = 'B';
                }
                if (rowsCoordinates.get(i) + radius < matrix.length && colsCoordinates.get(i) + radius < matrix[0].length){
                    matrix[rowsCoordinates.get(i) + radius][colsCoordinates.get(i) + radius] = 'B';
                }
            }
            //printMatrix();
            //System.out.println();
        }

        radius++;
    }

    private static void printMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
