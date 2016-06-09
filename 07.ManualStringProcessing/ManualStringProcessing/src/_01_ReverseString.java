import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String textString = bf.readLine();
        bf.close();

        StringBuilder reversedString = new StringBuilder();

        for (int i = textString.length() - 1; i >= 0; i--) {
            reversedString.append(textString.charAt(i));
        }

        System.out.println(reversedString.toString());
    }
}
