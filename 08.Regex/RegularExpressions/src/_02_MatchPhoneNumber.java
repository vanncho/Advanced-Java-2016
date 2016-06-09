import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String regex = "(\\+359(?<delim>[\\s-])\\d\\k<delim>\\d{3}\\k<delim>\\d{4})\\b";
        Matcher matcher;

        while (true){
            String line = input.nextLine();

            if (!line.equals("end")){

                Pattern pattern = Pattern.compile(regex);
                matcher = pattern.matcher(line);

                if (matcher.find()){
                    String result = matcher.group(0);
                    System.out.println(result);
                }
            } else {
                break;
            }
        }
    }
}
