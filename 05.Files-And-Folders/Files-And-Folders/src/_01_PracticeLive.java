import java.io.*;

public class _01_PracticeLive {
    public static void main(String[] args) throws IOException {

        File file = new File("/home/vancho/Desktop/text");

        //// read file
        //try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        //    String readLine = null;
//
        //    while ((readLine = br.readLine()) != null){
        //        System.out.println(readLine);
        //    }
        //}

        // write file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write("Hello");
        }
    }
}
