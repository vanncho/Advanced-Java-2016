import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _06_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String word = br.readLine();
        br.close();

        int count = 0;

        for (int i = 0; i <= text.length() - word.length(); i++) {
            String match = text.substring(i, i + word.length());

            if (match.equalsIgnoreCase(word)){
                count++;
            }
        }

        System.out.println(count);
    }
}
