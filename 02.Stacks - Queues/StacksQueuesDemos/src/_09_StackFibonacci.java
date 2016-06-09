import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _09_StackFibonacci {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        long n = console.nextLong();

        Queue<Long> queue = new ArrayDeque<>();
        long one = 1;
        queue.add(one);
        queue.add(one);

        for (int i = 0; i < n; i++) {
            long next = queue.remove() + queue.peek();
            queue.add(next);
        }

        System.out.println(queue.peek());
    }
}
