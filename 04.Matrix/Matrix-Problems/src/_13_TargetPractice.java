import java.util.Scanner;

public class _13_TargetPractice {
    static char[][] matrix;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();
        input.nextLine();

        String word = input.nextLine();
        String[] tokens = input.nextLine().split("\\s+");
        int impactRow = Integer.parseInt(tokens[0]);
        int impactCol = Integer.parseInt(tokens[1]);
        int radius = Integer.parseInt(tokens[2]);

        matrix = new char[rows][cols];

        fillMatrixWithString(word);

        bombTheMatrix(impactRow, impactCol, radius);

        // falling chars down
        int colIndex = 0;
        int holeRow = 0;
        int holeCol = 0;

        for (int i = cols; i > 0; i--) {

            boolean foundHole = false;
            boolean firstHole = true;
            int rowIndex = rows - 1;
            while (true){
                if (matrix[rowIndex][colIndex] == '\0'){
                    foundHole = true;

                    if (firstHole){
                        holeRow = rowIndex;
                        holeCol = colIndex;
                        firstHole = false;
                    }

                    rowIndex--;
                    if (rowIndex == -1){
                        break;
                    }
                    continue;
                }

                if (foundHole && matrix[rowIndex][colIndex] != '\0'){
                    char swap = matrix[holeRow][holeCol];
                    matrix[holeRow][holeCol] = matrix[rowIndex][colIndex];
                    matrix[rowIndex][colIndex] = swap;
                    foundHole = false;
                    firstHole = true;

                    if (rowIndex + 2 < rows){
                        rowIndex += 2;
                    }

                    if (rowIndex + 1 < rows){
                        rowIndex++;
                        continue;
                    }
                }

                rowIndex--;
                if (rowIndex == -1){
                    break;
                }
            }

            colIndex++;
        }

        printMatrix();
    }

    private static void bombTheMatrix(int impactRow, int impactCol, int radius) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int deltaX = (impactRow - i);
                int deltaY = (impactCol - j);

                boolean isPointInCircle = Math.sqrt(deltaX * deltaX + deltaY * deltaY) <= radius;

                if (isPointInCircle){
                    matrix[i][j] = '\0';
                }
            }
        }
    }

    private static void fillMatrixWithString(String word) {

        int fillDirection = 0;
        int charIndexInWord = 0;

        for (int i = matrix.length - 1; i >= 0; i--) {

            if (fillDirection % 2 == 0){
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[i][j] = word.charAt(charIndexInWord % word.length());
                    charIndexInWord++;
                }

            } else{
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = word.charAt(charIndexInWord % word.length());
                    charIndexInWord++;
                }
            }
            fillDirection++;
        }
    }

    public static void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != '\0'){
                    System.out.print(matrix[i][j]);
                } else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
