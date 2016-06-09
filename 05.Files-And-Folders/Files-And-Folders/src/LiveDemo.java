import java.io.*;
import java.util.HashSet;

public class LiveDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //// Files
        //File file = new File("/home/vancho/Desktop/text");
//
        //// Streams

        //// reader
        //try (BufferedReader bf = new BufferedReader(new FileReader(file))) { // BufferedReader за четене на текстов файл
        //    String readLine = null;
//
        //    while ((readLine = bf.readLine()) != null){
        //        System.out.println(readLine);
        //    }
        //}
        //// bf.close(); // ако не използваме try

        //// writer
        //File outputFile = new File("/home/vancho/Desktop/output");
//
        //try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))){
        //    bufferedWriter.write("Hello Java");
        //    bufferedWriter.newLine();
        //    bufferedWriter.write("Check is plased text on a new line.");
        //}

        // Serialization
        File file = new File("/home/vancho/Desktop/serialized");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false))){
            objectOutputStream.writeUTF("Hello !");
        }
    }
}

class Information implements Serializable {
    public HashSet<Integer> info = new HashSet<>();

    private static final long serialVersionUID = -1930889221156794788L;

    public transient String name; // transient, да не го записва

    public transient int number;
}
