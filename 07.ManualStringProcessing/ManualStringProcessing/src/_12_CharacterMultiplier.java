import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12_CharacterMultiplier {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("\\s+");
        String first = words[0];
        String second = words[1];
        br.close();

        String smallerWord = "";
        String biggerWord = "";

        if (first.length() < second.length()){
            smallerWord = first;
            biggerWord = second;
        } else if (second.length() < first.length()){
            smallerWord = second;
            biggerWord = first;
        } else{
            biggerWord = first;
            smallerWord = second;
        }

        int sum = 0;
        int lastIndex = 0;

        for (int i = 0; i < smallerWord.length(); i++) {
            int str1 = smallerWord.charAt(i);
            int str2 = biggerWord.charAt(i);
            lastIndex = i;

            sum += str1 * str2;
        }

        for (int i = lastIndex + 1; i < biggerWord.length(); i++) {
            sum += biggerWord.charAt(i);
        }

        System.out.println(sum);
    }
}
