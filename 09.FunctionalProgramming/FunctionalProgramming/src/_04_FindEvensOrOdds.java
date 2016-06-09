import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _04_FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        input.nextLine();
        String type = input.nextLine();

        for (int i = start; i <= end; i++) {

            if (type.equals("odd")){
                if (i % 2 != 0){
                    System.out.printf("%d ", i);
                }
            } else if (type.equals("even")){
                if (i % 2 == 0){
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}
