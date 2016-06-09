import java.math.BigInteger;
import java.util.Scanner;

public class _04_ConvertFromBase10ToBaseN {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int base = input.nextInt();
        String number = input.nextLine().trim();

        BigInteger bi = new BigInteger(number);
        String s = bi.toString(base);
        System.out.println(s);
    }
}
