import java.util.Scanner;

public class _12_RubiksMatrix {
    static int[][] rubik;
    static int[][] swapRubik;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int n = input.nextInt();

        input.nextLine();

        rubik = new int[r][c];
        swapRubik = new int[r][c];

        fillMatrixes();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("\\s+");
            int rowCol = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int moves = Integer.parseInt(tokens[2]);

            if (rowCol >= r || rowCol >= c){
                continue;
            }

            switch (direction){
                case "up":
                    for (int j = 0; j < moves % r; j++) {

                        int swapRows = 0;
                        int rubikRows = 1;

                        while (swapRows < r - 1){
                            swapRubik[swapRows][rowCol] = rubik[rubikRows][rowCol];
                            rubikRows++;
                            swapRows++;
                        }

                        swapRubik[swapRows][rowCol] = rubik[0][rowCol];
                        updateRubikRow(r, rowCol);
                    }
                    break;
                case "right":;
                    for (int j = 0; j < moves % c; j++) {

                        int swapCols = 0;
                        int rubikCols = c - 1;
                        swapRubik[rowCol][swapCols] = rubik[rowCol][rubikCols];
                        swapCols++;
                        rubikCols = 0;

                        while (swapCols < c){
                            swapRubik[rowCol][swapCols] = rubik[rowCol][rubikCols];
                            rubikCols++;
                            swapCols++;
                        }

                        updateRubikCol(c, rowCol);
                    }
                    break;
                case "down":
                    for (int j = 0; j < moves % r; j++) {

                        int swapRows = 0;
                        int rubikRows = r - 1;

                        swapRubik[swapRows][rowCol] = rubik[rubikRows][rowCol];
                        swapRows++;
                        rubikRows = 0;

                        while (swapRows < r){
                            swapRubik[swapRows][rowCol] = rubik[rubikRows][rowCol];
                            rubikRows++;
                            swapRows++;
                        }

                        updateRubikRow(r, rowCol);
                    }
                    break;
                case "left":
                    for (int j = 0; j < moves % c; j++) {

                        int swapCols = 0;
                        int rubikCols = 1;

                        while (swapCols < c - 1){
                            swapRubik[rowCol][swapCols] = rubik[rowCol][rubikCols];
                            rubikCols++;
                            swapCols++;
                        }

                        rubikCols = 0;
                        swapRubik[rowCol][swapCols] = rubik[rowCol][rubikCols];

                        updateRubikCol(c, rowCol);
                    }
                    break;
            }
        }

        int count = 1;

        for (int i = 0; i < rubik.length; i++) {
            for (int j = 0; j < rubik[i].length; j++) {

                if (swapRubik[i][j] == count){
                    System.out.println("No swap required");
                    count++;
                } else {
                    int swap = 0;
                    boolean isSwaped = false;
                    for (int k = 0; k < swapRubik.length; k++) {

                        if (!isSwaped){
                            for (int l = 0; l < swapRubik[i].length; l++) {

                                if (swapRubik[k][l] == count){
                                    System.out.printf("Swap (%d, %d) with (%d, %d)", i, j, k, l).println();

                                    swap = swapRubik[k][l];
                                    swapRubik[k][l] = swapRubik[i][j];
                                    swapRubik[i][j] = swap;
                                    count++;
                                    isSwaped = true;
                                    break;
                                }
                            }
                        } else{
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void updateRubikCol(int col, int rowCol) {

        for (int i = 0; i < col; i++) {
            rubik[rowCol][i] = swapRubik[rowCol][i];
        }
    }

    private static void updateRubikRow(int row, int rowCol) {

        for (int i = 0; i < row; i++) {
            rubik[i][rowCol] = swapRubik[i][rowCol];
        }
    }

    public static void fillMatrixes(){
        int num = 1;
        for (int i = 0; i < rubik.length; i++) {
            for (int j = 0; j < rubik[i].length; j++) {
                rubik[i][j] = num;
                swapRubik[i][j] = num;
                num++;
            }
        }
    }
}
