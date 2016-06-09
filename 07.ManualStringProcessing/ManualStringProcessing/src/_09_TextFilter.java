import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _09_TextFilter {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(", ");
        String text = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < words.length; i++) {
            String searchedWord = words[i];
            String replacedAsterisks = getSerchedWordLengthInAsterisks(searchedWord.length());

            for (int j = 0; j <= text.length() - searchedWord.length(); j++) {
                String currWord = text.substring(j, j + searchedWord.length());

                if (searchedWord.equals(currWord)){
                    sb.replace(j, j + searchedWord.length(), replacedAsterisks);
                }
            }
        }

        System.out.println(sb);
    }

    private static String getSerchedWordLengthInAsterisks(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append('*');
        }

        return sb.toString();
    }
}
