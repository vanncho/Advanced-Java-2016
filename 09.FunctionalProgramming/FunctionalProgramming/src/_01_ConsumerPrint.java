import java.util.Scanner;
        import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] names = input.nextLine().split("\\s+");

        Consumer<String> print = message -> System.out.println(message);

        for (String name : names) {
            print.accept(name);
        }
    }
}
