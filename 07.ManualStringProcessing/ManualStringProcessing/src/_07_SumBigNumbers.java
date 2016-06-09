import java.util.Scanner;

public class _07_SumBigNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        String second = input.nextLine();

        if (first.length() < second.length()){
            first = padWithZeros(first, second.length() - first.length());
        }
        if (second.length() < first.length()){
            second = padWithZeros(second, first.length() - second.length());
        }

        StringBuilder newNumber = new StringBuilder();
        int rest = 0;

        for (int i = first.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(first.charAt(i) + "");
            int b = Integer.parseInt(second.charAt(i) + "");

            if (a + b + rest < 10){
                newNumber.append((a + b + rest) + "");
                rest = 0;
            } else if (a + b + rest >= 10){
                int reminder = (a + b + rest) - 10;
                newNumber.append(reminder + "");
                rest = 1;
            }
        }

        if (rest != 0){
            newNumber.append(rest + "");
        }

        StringBuilder reversed = new StringBuilder();

        for (int i = newNumber.length() - 1; i >= 0; i--) {
            reversed.append(newNumber.charAt(i));
        }

        // clear zeroes
        if (reversed.charAt(0) == '0'){
            while (reversed.charAt(0) == '0'){
                if (reversed.length() > 1){
                    reversed.deleteCharAt(0);
                } else {
                    break;
                }
            }
        }

        System.out.println(reversed.toString());
    }

    private static String padWithZeros(String first, int length) {

        StringBuilder sb = new StringBuilder(first);

        for (int i = 0; i < length; i++) {
            sb.insert(0, '0');
        }

        return sb.toString();
    }
}
