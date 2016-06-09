import java.util.Scanner;
import java.util.TreeMap;

public class _05_Phonebook {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String line = console.nextLine();
        TreeMap<String, String> phonebook = new TreeMap<>();

        while (!line.equals("search")){
            String[] tokens = line.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            phonebook.put(name, phone);
            line = console.nextLine();
        }

        line = console.nextLine();
        while (!line.equals("stop")){
            String name = line;

            if (phonebook.containsKey(name)){
                System.out.printf("%s -> %s", name, phonebook.get(name)).println();
            } else{
                System.out.printf("Contact %s does not exist.", name).println();
            }

            line = console.nextLine();
        }
    }
}
