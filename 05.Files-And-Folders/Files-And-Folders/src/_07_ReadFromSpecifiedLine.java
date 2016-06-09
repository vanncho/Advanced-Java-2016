import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _07_ReadFromSpecifiedLine {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        File file = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/03_LineNumbers/02_LinesOut.txt");
        boolean printRow = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String readLine = null;
            int rowCount = 1;

            while((readLine = bufferedReader.readLine()) != null){
                String line = readLine;

                if (rowCount >= n){
                    System.out.println(readLine);
                    printRow = true;
                }
                rowCount++;
            }
        }

        if (!printRow){
            System.out.println("No such row number.");
        }
    }
}
