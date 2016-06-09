import java.util.LinkedList;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        LinkedList<Integer> stack = new LinkedList<>();
        console.nextLine();

        for (int i = 0; i < n; i++) {
            String readLine = console.nextLine();

            if (readLine.length() == 1){
                int command = Integer.parseInt(readLine);

                if (command == 2){
                    stack.pop();
                } else {
                    int max = Integer.MIN_VALUE;
                    for (Integer element : stack) {

                        if (element > max){
                            max = element;
                        }
                    }
                    System.out.println(max);

                }

            } else{

                String[] splitted = readLine.split(" ");
                //String currCommand = splitted[0];
                int element = Integer.parseInt(splitted[1]);

                stack.push(element);
            }
        }
    }
}
