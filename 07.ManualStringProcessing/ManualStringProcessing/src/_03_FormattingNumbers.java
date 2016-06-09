import java.util.Locale;
import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        double b = input.nextDouble();
        double c = input.nextDouble();

        String aToBinary = Integer.toString(a, 2);
        if (aToBinary.length() > 10){
            aToBinary = aToBinary.substring(0, 10);
        } else if (aToBinary.length() < 10){
            aToBinary = padLeftWithZeros(aToBinary, 10 - aToBinary.length());
        }

        String aToHex = Integer.toHexString(a);
        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", aToHex.toUpperCase(), aToBinary, b, c);
    }

    private static String padLeftWithZeros(String str, int count){

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < count; i++) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
