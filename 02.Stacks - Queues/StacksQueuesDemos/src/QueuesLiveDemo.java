import java.util.ArrayDeque;
import java.util.Queue;

public class QueuesLiveDemo {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(5);
        queue.add(6);

        System.out.println(queue.peek());
        System.out.println("------");
        System.out.println(queue.peek());

        queue.remove();
        System.out.println(queue.peek());
    }
}
