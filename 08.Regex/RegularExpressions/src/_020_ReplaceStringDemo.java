import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _020_ReplaceStringDemo {
    public static void main(String[] args) {

        String names = "Pesho, Ivan, Gosho, Tosho";

        String regex = ", ";

        //// replace with string
        //String newNames = names.replaceAll(regex, ":");

        // replace with matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);
        String newNames = matcher.replaceAll(":");

        System.out.println(newNames);
    }
}
