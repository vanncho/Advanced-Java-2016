import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10_UseYourChainsBuddy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        if (text.equals("")){
            return;
        }

        //String pTagContentRegex = "<p>([^<]+)<\\/p>";
        String pTagContentRegex = "<p>([^>]+(<\\w+>)?)<\\/?p>";
        Pattern pattern = Pattern.compile(pTagContentRegex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder toPrint = new StringBuilder();

        while (matcher.find()){
            String match = matcher.group(1);
            match = match.replaceAll("[^a-z0-9]+", " ");
            match = match.replaceAll("\\s+", " ");

            StringBuilder formatedText = new StringBuilder();
            for (int i = 0; i < match.length(); i++) {

                char currChar = match.charAt(i);

                if (currChar >= 'a' && currChar <= 'm'){
                    currChar += 13;
                } else if (currChar >= 'n' && currChar <= 'z'){
                    currChar -= 13;
                }

                formatedText.append(currChar);
            }

            toPrint.append(formatedText);
        }

        System.out.println(toPrint.toString());
    }
}
