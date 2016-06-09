import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class _11_Palindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("\\W+");
        br.close();

        LinkedHashSet<String> palindromesWords = new LinkedHashSet<>();

        for (int i = 0; i < words.length; i++) {

            if (isPalindrome(words[i])){
                palindromesWords.add(words[i]);
            }
        }

        List<String> uniquePalindromesToArray = new ArrayList<String>(palindromesWords);

        Collator myCollator = Collator.getInstance(Locale.US);
        myCollator.setStrength(Collator.PRIMARY);
        Collections.sort(uniquePalindromesToArray, myCollator);

        System.out.println(uniquePalindromesToArray);
    }

    private static boolean isPalindrome(String word) {

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) != word.charAt(word.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }
}
