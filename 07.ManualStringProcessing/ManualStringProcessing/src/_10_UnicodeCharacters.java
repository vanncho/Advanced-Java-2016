import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10_UnicodeCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        br.close();

        for (int i = 0; i < text.length(); i++) {
            System.out.print(toUnicode(text.charAt(i)));
        }
        System.out.println();
    }

    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
