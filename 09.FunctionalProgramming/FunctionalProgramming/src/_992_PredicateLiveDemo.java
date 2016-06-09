import java.util.function.Predicate;

public class _992_PredicateLiveDemo {
    public static void main(String[] args) {
        String[] words = new String[]{"stone", "rocket", "mallet", "skull"};

        Predicate<String> startsWithS = word -> word.startsWith("s"); // Predicate returns TRUE or FALSE only !
        Predicate<String> endsWithE = word -> word.endsWith("e");

        for (String word : words) {
            if (startsWithS.test(word) && (endsWithE.test(word))){
                System.out.println(word);
            }
        }
    }
}
