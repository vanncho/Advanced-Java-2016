import java.util.Scanner;

public class _00_LiveDemos {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //int[][] matrix = new int[5][5];
        int[][] matrix = new int[5][];

        // if we don't know the columns size
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
    }
}
