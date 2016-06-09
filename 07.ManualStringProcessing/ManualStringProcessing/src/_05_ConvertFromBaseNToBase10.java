import java.math.BigInteger;
import java.util.Scanner;

public class _05_ConvertFromBaseNToBase10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int base = input.nextInt();
        BigInteger number = input.nextBigInteger();

        BigInteger pow = new BigInteger("1");
        BigInteger resNumber = new BigInteger("0");

        while (number.compareTo(BigInteger.ZERO) > 0){

            BigInteger digit = number.divideAndRemainder(new BigInteger("10"))[1];
            number = number.divide(new BigInteger("10"));
            resNumber = resNumber.add(digit.multiply(pow));
            pow = pow.multiply(new BigInteger(base + ""));
        }

        System.out.println(resNumber);
    }
}
