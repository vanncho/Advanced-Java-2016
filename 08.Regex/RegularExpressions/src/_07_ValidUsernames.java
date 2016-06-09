import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_ValidUsernames {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        if (!line.equals("")){
            String validateUserName = "^[a-zA-Z]\\w{2,24}$";
            String[] tokens = line.split("[\\s\\/\\(\\)\\\\]+");

            Pattern pattern = Pattern.compile(validateUserName);

            List<String> usernNames = new ArrayList<>();
            for (int i = 0; i < tokens.length; i++) {

                Matcher matcher = pattern.matcher(tokens[i]);

                if (matcher.find()){
                    usernNames.add(matcher.group().trim());
                }
            }

            if (usernNames.size() >= 2){
                int maxSum = -1;
                int firstWord = 0;
                int secondWord = 0;
                for (int i = 0; i < usernNames.size() - 1; i++) {
                    int wordSumOne = usernNames.get(i).length();
                    int wordSumTwo = usernNames.get(i + 1).length();

                    if ((wordSumOne + wordSumTwo) > maxSum){
                        maxSum = wordSumOne + wordSumTwo;
                        firstWord = i;
                        secondWord = i + 1;
                    }
                }

                for (int i = firstWord; i <= secondWord; i++) {
                    System.out.println(usernNames.get(i));
                }
            } else if (usernNames.size() == 1){
                System.out.println(usernNames.get(0));
            }
        }
    }
}
