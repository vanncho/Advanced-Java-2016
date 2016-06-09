import java.util.LinkedHashSet;
import java.util.Scanner;

public class _02_SetsOfElements {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int m = console.nextInt();

        LinkedHashSet<Integer> sets = new LinkedHashSet();

        for (int i = 0; i < n; i++) {
            int currNum = console.nextInt();
            sets.add(currNum);
        }

        for (int i = 0; i < m; i++) {
            int currNum = console.nextInt();
            if (!sets.contains(currNum)){
                sets.add(currNum);
            } else{
                System.out.printf("%d ", currNum);
            }
        }
    }
}
