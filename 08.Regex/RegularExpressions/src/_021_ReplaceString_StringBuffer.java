import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _021_ReplaceString_StringBuffer {
    public static void main(String[] args) {

        String text = "Pesho - 4123, Ivan - 32525, Gosho - 214123, Tosho";
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()){
            String match = matcher.group(0);
            String replacementString = makeReplacementString(match);

            matcher.appendReplacement(buffer, replacementString);
        }

        matcher.appendTail(buffer);

        System.out.println(buffer);
    }

    private static String makeReplacementString(String match) {
        String result = "";

        for (int i = 0; i < match.length(); i++) {
            result = result + "*";
        }
        
        return result;
    }
}
