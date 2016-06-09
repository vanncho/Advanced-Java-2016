import java.io.*;

public class _04_MergingTwoFilesIntoThirdOne {
    public static void main(String[] args) throws IOException {

        File firstFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/05_MergingFiles/01_FileOne.txt");
        File secondFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/05_MergingFiles/01_FileTwo.txt");
        File mergedFile = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/05_MergingFiles/01_result.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile));
             BufferedReader bufferedReaderTwo = new BufferedReader(new FileReader(secondFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mergedFile, true))) {

            boolean firstFinished = false;
            boolean secondFinished = false;
            String line = null;
            String lineTwo = null;

            while (true){

                if ((line = bufferedReader.readLine()) != null){
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } else if ((line = bufferedReader.readLine()) == null){
                    firstFinished = true;
                }

                if ((lineTwo = bufferedReaderTwo.readLine()) != null){
                    bufferedWriter.write(lineTwo);
                    bufferedWriter.newLine();
                } else if ((lineTwo = bufferedReaderTwo.readLine()) == null){
                    secondFinished = true;
                }

                if (firstFinished && secondFinished){
                    break;
                }
            }
        }
    }
}
