import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_SentenceExtractor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String text = input.nextLine();

        String sentenceRegex = "(?<=\\s|^)[^!.?]*\\b"+ word+ "\\b[^!.?]*[!.?]";
        Pattern pattern = Pattern.compile(sentenceRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }
    }
}
