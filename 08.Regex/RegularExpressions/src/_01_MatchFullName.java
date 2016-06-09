import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_MatchFullName {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String regex = "(\\b[A-Z][a-z]{1,} [A-Z][a-z]{1,})";
        Matcher matcher;

        while (true){
            String line = input.nextLine();
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(line);

            if (!line.equals("end")){
                if (matcher.find()){
                    String toPrint = matcher.group(1);
                    System.out.println(toPrint);
                }
            } else {
                break;
            }
        }
    }
}
