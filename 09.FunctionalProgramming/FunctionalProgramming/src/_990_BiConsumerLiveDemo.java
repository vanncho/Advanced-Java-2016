import java.util.function.BiConsumer;

public class _990_BiConsumerLiveDemo {
    public static void main(String[] args) {

        String[] greetingMessages = new String[]{"Hello", "Zdravei", "Holla", "Bonjuor", "Ciao"};

        BiConsumer<String, String> print = (message, name) -> System.out.printf("%s %s!\n", message, name);

        for (String greetingMessage : greetingMessages) {
            print.accept(greetingMessage, "Ivan");
        }
    }
}
