import java.io.File;

public class _05_GetFolderSize {
    public static void main(String[] args) {

        File file = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/TestFolder");

        long allFilesSizes = 0L;
        if (file.isDirectory()){
            File[] filesInGivenDirectory = file.listFiles();

            for (File currFile : filesInGivenDirectory) {
                long currSum = currFile.length();
                allFilesSizes += currSum;
            }
        }

        int mbDelimiter = 1048576;
        double sizeInMB = (double)allFilesSizes / mbDelimiter;
        System.out.printf("%f MB", sizeInMB);
    }
}
