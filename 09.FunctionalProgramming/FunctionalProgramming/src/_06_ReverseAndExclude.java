import java.util.Scanner;

public class _06_ReverseAndExclude {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("\\s+");
        int n = input.nextInt();

        for (int i = numAsStrings.length - 1; i >= 0; i--) {
            int num = Integer.parseInt(numAsStrings[i]);

            if (num % n == 0){
                continue;
            }

            System.out.printf("%d ", num);
        }
    }
}
