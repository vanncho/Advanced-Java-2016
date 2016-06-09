import java.util.function.Function;

public class _994_FunctionLiveDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> increment = number -> number + 1;

        int a = increment.apply(5);
        System.out.println(a);

        int b = increment.apply(a);
        System.out.println(b);
    }
}
