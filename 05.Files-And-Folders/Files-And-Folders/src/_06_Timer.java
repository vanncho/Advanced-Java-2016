import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class _06_Timer {
    public static void main(String[] args) throws IOException {

        File first = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/03_LineNumbers/01_LinesIn.txt");
        File second = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/03_LineNumbers/02_LinesIn.txt");

        // first file
        long startTime = System.nanoTime();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(first))){

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                bufferedReader.readLine();
            }
        }

        long estimateTime = System.nanoTime() - startTime;
        double timeInSecondsFirst = (double)estimateTime / 1_000_000_000;

        // second file
        startTime = System.nanoTime();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(second))){

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                bufferedReader.readLine();
            }
        }

        estimateTime = System.nanoTime() - startTime;
        double timeInSecondsSecond = (double)estimateTime / 1_000_000_000;

        if (timeInSecondsFirst < timeInSecondsSecond){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.printf("first file: %f seconds", timeInSecondsFirst).println();
        System.out.printf("second file: %f seconds", timeInSecondsSecond).println();
    }
}
