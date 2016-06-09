import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _13_MagicExchangeableWords {
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

        Map<Character, Character> magic = new HashMap<>();
        boolean isMagic = true;
        int index = 0;

        for (int i = 0; i < smallerWord.length(); i++) {
            char chFirstWord = biggerWord.charAt(i);
            char chSecondWord = smallerWord.charAt(i);
            index = i;

            if (!magic.containsKey(chFirstWord)){
                magic.put(chFirstWord, chSecondWord);
            } else if (magic.containsKey(chFirstWord)){

                if (magic.get(chFirstWord) != chSecondWord) {
                    isMagic = false;
                }
            }
        }

        boolean quit = false;

        if (first.length() != second.length() && isMagic){
            for (int i = index + 1; i < biggerWord.length(); i++) {

                if (quit){
                    break;
                }

                char ch = biggerWord.charAt(i);

                for (Character character : magic.keySet()) {

                    if (quit){
                        break;
                    }

                    if (!magic.containsKey(ch)){
                        isMagic = false;
                        quit = true;
                        break;
                    } else{

                        isMagic = true;
                    }
                }
            }
        }

        System.out.println(isMagic);
    }
}
