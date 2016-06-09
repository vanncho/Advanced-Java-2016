import java.util.Scanner;

public class _14_LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split("\\s+");

        double sum = 0d;

        for (int i = 0; i < tokens.length; i++) {

            String currStr = tokens[i];
            char left = currStr.charAt(0);
            char right = currStr.charAt(currStr.length() - 1);
            double number = Double.parseDouble(currStr.substring(1, currStr.length() - 1));

            double tempSum = 0d;
            if (left >= 65 && left <= 90){ // upper case
                tempSum += number / (left - 64);

                if (right >= 65 && right <= 90){
                    tempSum -= (right - 64);
                } else{
                    tempSum += (right - 96);
                }
            } else if (left >= 97 && left <= 122){ // lower case
                tempSum += number * (left - 96);

                if (right >= 65 && right <= 90){
                    tempSum -= (right - 64);
                } else{
                    tempSum += (right - 96);
                }
            }

            sum += tempSum;
        }

        System.out.printf("%.2f", sum);
    }
}
