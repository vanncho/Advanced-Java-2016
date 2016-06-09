import java.util.Scanner;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        TreeSet<String> periodic = new TreeSet<>();
        console.nextLine();

        for (int i = 0; i < n; i++) {
            String[] tokens = console.nextLine().split("\\s+");

            for (int j = 0; j < tokens.length; j++) {
                String currEl = tokens[j];

                periodic.add(currEl);
            }
        }

        for (String s : periodic) {
            System.out.printf("%s ", s);
        }
    }
}
