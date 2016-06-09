import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_UniqueUsernames {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        String user = console.nextLine();

        LinkedHashSet<String> usernames = new LinkedHashSet();

        for (int i = 0; i < n; i++) {
            user = console.nextLine();
            usernames.add(user);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
