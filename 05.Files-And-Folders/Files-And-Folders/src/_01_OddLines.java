import java.io.*;

public class _01_OddLines {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/02_OddLines/03_OddLinesIn.txt");
        File outputFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/02_OddLines/03_OddLinesOut.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){
            String readLine = null;

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

                int count = 0;
                while ((readLine = bufferedReader.readLine()) != null){
                    if (count % 2 != 0){
                        bufferedWriter.write(readLine);
                        bufferedWriter.newLine();
                    }
                    count++;
                }
            }
        }
    }
}
