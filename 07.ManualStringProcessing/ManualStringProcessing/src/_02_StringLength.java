import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_StringLength {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        br.close();
        StringBuilder processingTest = new StringBuilder(text);

        if (text.length() < 20){
            int diff = 20 - text.length();

            for (int i = 0; i < diff; i++) {
                processingTest.append('*');
            }

            System.out.println(processingTest);
        } else {
            text = text.substring(0, 20);
            System.out.println(text);
        }
    }
}
