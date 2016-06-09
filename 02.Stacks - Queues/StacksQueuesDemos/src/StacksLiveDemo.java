import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StacksLiveDemo {
    public static void main(String[] args) {

        //Stack<Integer> stack = new Stack<>(); // not recomended to use - old and wrong
        LinkedList<Integer> stack = new LinkedList<>();
        //stack.add(5);
        //stack.add(6);
        //stack.add(7);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.peek());
        //System.out.println(stack.peekLast());
    }
}
