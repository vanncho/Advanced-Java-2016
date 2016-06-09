import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_ExtractEmails {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String regex = "(?<=^| )([a-z]+[._-]?[\\w+._-]+@[\\w+_-]+[.]?[\\w+_-]?[.]?[a-z]{1,}?\\.[a-z]{2,})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            String result = matcher.group(0);
            System.out.println(result);
        }
    }
}
