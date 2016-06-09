import java.util.LinkedList;
import java.util.Scanner;

public class _01_ReverseNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] splitted = console.nextLine().split(" ");
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < splitted.length; i++) {
            int currentNum = Integer.parseInt(splitted[i]);

            stack.push(currentNum);
        }

        // print
        for (Integer n : stack) {

            System.out.printf("%d ", n);
        }
    }
}
