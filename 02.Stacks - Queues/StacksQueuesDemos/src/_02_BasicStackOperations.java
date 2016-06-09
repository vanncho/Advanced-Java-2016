import java.util.LinkedList;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        
        String[] commands = console.nextLine().split(" ");
        int elementsToPush = Integer.parseInt(commands[0]);
        int elementsToPop = Integer.parseInt(commands[1]);
        int elementToSearch = Integer.parseInt(commands[2]);

        String[] readElements = console.nextLine().split(" ");
        LinkedList<Integer> elements = new LinkedList<>();

        for (int i = 0; i < elementsToPush; i++) {
            int currNum = Integer.parseInt(readElements[i]);
            elements.push(currNum);
        }

        // pop elements
        for (int i = 0; i < elementsToPop; i++) {
            elements.pop();
        }

        // search for element
        if (elements.contains(elementToSearch)){
                System.out.println(true);
            } else{
                if (elements.size() > 0){
                    int min = Integer.MAX_VALUE;
                    for (Integer element : elements) {

                        if (element < min){
                            min = element;
                        }
                    }
                    System.out.println(min);
                } else{
                    System.out.println(0);
                }
            }
        }
    }
