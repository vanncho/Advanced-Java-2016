import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class _05_CalculateSequenceWithQueue {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        long n = console.nextLong();

        Queue<Long> queue = new ArrayDeque<>();
        ArrayList<Long> sequences = new ArrayList<>();
        queue.add(n);
        sequences.add(n);

        long first = queue.peek();
        long second = 0;
        long third = 0;

        while (sequences.size() < 60) {

            second = queue.peek() + 1;
            queue.add(second);
            sequences.add(second);

            third = (2 * queue.peek()) + 1;
            queue.add(third);
            sequences.add(third);

            sequences.add(queue.peek() + 2);
            queue.add(queue.peek() + 2);
            first = queue.remove();
        }

        for (int i = 0; i < 50; i++) {
            System.out.printf("%d ", sequences.get(i));
        }
    }
}
