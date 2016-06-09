import java.io.*;

public class _02_LineNumbers {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/03_LineNumbers/03_LinesIn.txt");
        File outputFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/03_LineNumbers/03_LinesOut.txt");

        //// my try (works)
        //try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){
        //    String readLine = null;
//
        //    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))){
//
        //        int lineNumbers = 1;
        //        while ((readLine = bufferedReader.readLine()) != null){
        //            bufferedWriter.write(lineNumbers + ". " + readLine);
        //            bufferedWriter.newLine();
//
        //            lineNumbers++;
        //        }
        //    }
        //}

        // try from video (works)
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, true));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){

            String readLine = null;
            int lineNumbers = 1;
            while ((readLine = bufferedReader.readLine()) != null){
                bufferedWriter.write(lineNumbers + ". " + readLine);
                bufferedWriter.newLine();
                lineNumbers++;
            }
        }
    }
}
