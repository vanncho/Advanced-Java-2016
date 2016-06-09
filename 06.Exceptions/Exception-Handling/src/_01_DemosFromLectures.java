import java.io.*;

public class _01_DemosFromLectures {
    public static void main(String[] args) throws IOException {

        //Integer i = null;
        //try {
        //    i++;
        //} catch (NullPointerException ex) {
        //    //File file = new File("/home/vancho/Desktop/test");
        //    //try (PrintWriter printWriter = new PrintWriter(file)) {
        //    //    ex.printStackTrace(printWriter);
        //    //}
//
        //    StackTraceElement[] array = ex.getStackTrace();
        //    array[0].getClassName();
        //    System.out.println(array[0].getFileName());
        //} catch (ArrayIndexOutOfBoundsException ex) {
//
        //} finally {
        //
        //}


        BufferedWriter bw = new BufferedWriter(new FileWriter("asssdd"));

        try{
            bw.write("sad");
        } finally {
            bw.close();
        }

    }
}
