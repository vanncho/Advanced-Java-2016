import java.util.Scanner;

public class _08_RecursiveFibonacci {

    static long[] numbers;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        long n = console.nextLong();

        numbers = new long[(int)n + 2];
        numbers[0] = 1;
        numbers[1] = 1;

        long result = getFibonacci(n);

        System.out.println(result);
    }

    public static long getFibonacci(long n){

        if (numbers[(int)n] == 0)
        {
            numbers[(int)n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }

        return numbers[(int)n];
    }
}
