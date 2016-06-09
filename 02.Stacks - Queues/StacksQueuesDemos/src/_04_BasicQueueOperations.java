import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        String[] splitted = line.split(" ");
        int elementsToAdd = Integer.parseInt(splitted[0]);
        int elementsToRemove = Integer.parseInt(splitted[1]);
        int elementsToSearch = Integer.parseInt(splitted[2]);

        Queue<Integer> numbers = new ArrayDeque<>();

        // add elements
        for (int i = 0; i < elementsToAdd; i++) {
            int currElement = console.nextInt();
            numbers.add(currElement);
        }

        // remove elements
        for (int i = 0; i < elementsToRemove; i++) {
            numbers.remove();
        }

        // print result
        if (numbers.contains(elementsToSearch)){
            System.out.println(true);
        } else {
            if (numbers.size() > 0){
                int min = Integer.MAX_VALUE;

                for (Integer number : numbers) {
                    if (number < min){
                        min = number;
                    }
                }

                System.out.println(min);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
