import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        TreeMap<Character, Integer> letters = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!letters.containsKey(ch)){
                letters.put(ch, 1);
            } else{
                letters.computeIfPresent(ch, (k,v) -> v + 1);
            }
        }

        for (Character ch : letters.keySet()) {
            int count = letters.get(ch);
            System.out.printf("%s: %d time/s", ch, count).println();
        }
    }
}
