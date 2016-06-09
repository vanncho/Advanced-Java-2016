import java.util.Scanner;

public class _03_SeriesOfLetters {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String newText = text.replaceAll("(.)\\1+", "$1");
        System.out.println(newText);
    }
}
