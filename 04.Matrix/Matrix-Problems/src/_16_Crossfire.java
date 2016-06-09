// кода е за пренаписване целият. Омазан е яко! Дава 50/100 точки.













import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _16_Crossfire {

    static List<List<Integer>> matrix;
    static int rows;
    static int cols;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String line = console.nextLine();
        String[] splitted = line.split("\\s+");
        rows = Integer.parseInt(splitted[0]);
        cols = Integer.parseInt(splitted[1]);
        matrix = fillMatrixByGivenSize(rows, cols);

        while (true) {
            line = console.nextLine();

            if (!line.equals("Nuke it from orbit")) {
                String[] destroyCommands = line.split("\\s+");
                int initialRow = Integer.parseInt(destroyCommands[0]);
                int initialCol = Integer.parseInt(destroyCommands[1]);
                int destroyRadius = Integer.parseInt(destroyCommands[2]);

                if (initialRow < 0 && initialCol < 0 || (initialRow >= rows && initialCol >= cols)) {
                    continue;
                }
                getProcessDestroy(initialRow, initialCol, destroyRadius, rows, cols);
                updateMatrixStatus();
                //printMatrix(matrix);
                //System.out.println();
            } else {
                break;
            }
        }

        printMatrix(matrix);
    }

    private static void updateMatrixStatus() {

        for (int i = 0; i < matrix.size(); i++) {

            List<Integer> currCol = matrix.get(i);

            if (currCol.size() == 0){
                matrix.remove(i);
                continue;
            }

            for (int j = currCol.size() - 1; j >= 0; j--) {

                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).remove(j);
                }
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++) {

            List<Integer> currCol = matrix.get(i);

            for (int j = 0; j < currCol.size(); j++) {
                System.out.printf("%d ", matrix.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static void getProcessDestroy(int initialRow, int initialCol, int destroyRadius, int rows, int cols) {

        boolean rowsMinus = false;
        boolean colsMinus = false;
        boolean rowsOverMax = false;
        boolean colsOverMax = false;

        if (initialRow < 0){
            destroyRadius = (destroyRadius + initialRow);
            initialRow = 0;
            rowsMinus = true;
        }
        if (initialCol < 0){
            destroyRadius = (destroyRadius + initialCol);
            initialCol = 0;
            colsMinus = true;
        }
        if (initialRow > matrix.size() - 1){
            destroyRadius = (destroyRadius % rows) - 1;
            initialRow = matrix.size() - 1;
            rowsOverMax = true;
        }
        if (initialCol > cols - 1){
            destroyRadius = (destroyRadius % cols) - 1;
            initialCol = cols - 1;
            colsOverMax= true;
        }

        int currRowPos = initialRow;
        int currColPos = initialCol;
        int radius = destroyRadius;

        if (matrix.size() > 0 && matrix.get(currRowPos).size() > currColPos){
            matrix.get(currRowPos).set(currColPos, 0);
        }

        // go top
        if (!colsMinus && !colsOverMax){
            for (int i = 0; i < destroyRadius; i++) {
                if (currRowPos - 1 > -1 && radius > -1){
                    currRowPos--;
                }
                else{
                    break;
                }

                if (matrix.size() > 0 && matrix.get(currRowPos).size() > currColPos){
                    matrix.get(currRowPos).set(currColPos, 0);
                }
                radius--;
            }
        }

        // go right
        currRowPos = initialRow;
        currColPos = initialCol;
        radius = destroyRadius;

        if (!rowsMinus && !rowsOverMax){
            for (int i = 0; i < destroyRadius; i++) {
                if (currColPos + 1 < cols && radius > - 1){
                    currColPos++;
                }
                else{
                    break;
                }

                if (matrix.size() > 0 && matrix.get(currRowPos).size() > currColPos){
                    matrix.get(currRowPos).set(currColPos, 0);
                }
                radius--;
            }
        }

        // go down
        currRowPos = initialRow;
        currColPos = initialCol;
        radius = destroyRadius;
        if (!colsMinus && !colsOverMax){
            for (int i = 0; i < destroyRadius; i++) {
                if (currRowPos + 1 < matrix.size() && radius > -1){
                    currRowPos++;
                }
                else{
                    break;
                }

                if (matrix.size() > 0 && matrix.get(currRowPos).size() > currColPos){
                    matrix.get(currRowPos).set(currColPos, 0);
                }
                radius--;
            }
        }

        // go left
        currRowPos = initialRow;
        currColPos = initialCol;
        radius = destroyRadius;

        if (!rowsMinus && !rowsOverMax){
            for (int i = 0; i < destroyRadius; i++) {
                if (currColPos - 1 > - 1 && radius > -1){
                    currColPos--;
                }
                else{
                    break;
                }

                if (matrix.size() > 0 && matrix.get(currRowPos).size() > currColPos){
                    matrix.get(currRowPos).set(currColPos, 0);
                }
                radius--;
            }
        }
    }

    private static List<List<Integer>> fillMatrixByGivenSize(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();

        int fill = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> currCol = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                currCol.add(fill);
                fill++;
            }
            matrix.add(currCol);
        }
        return matrix;
    }
}
