import java.util.function.BiPredicate;

public class _993_BiPredicateLiveDemo {
    public static void main(String[] args) {
        String[] words = new String[]{"stone", "rocket", "mallet", "skull"};

        BiPredicate<String, String> biPredicate = (word, suffix) -> word.endsWith(suffix);

        for (String word : words) {
            if (biPredicate.test(word, "et")){
                System.out.println(word);
            }
        }
    }
}
