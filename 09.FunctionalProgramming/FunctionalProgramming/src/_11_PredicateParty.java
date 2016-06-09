import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _11_PredicateParty {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] names = input.nextLine().split("\\s+");
        List<String> namesToList = Arrays.asList(names);

        while (true) {
            String line = input.nextLine();

            if (line.equals("Party!")) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String mainCommand = tokens[0];
            String semiCommand = tokens[1];
            String lastCommand = tokens[2];

            Predicate<String> tester = processSemiAndLastCommands(semiCommand, lastCommand);

            if (mainCommand.equals("Double")){

            } else if (mainCommand.equals("Remove")) {

            }
        }
    }

    private static Predicate<String> processSemiAndLastCommands(String semiCommand, String lastCommand) {

        switch (semiCommand) {
            case "StartsWith":
                return str -> str.startsWith(lastCommand);
            case "EndsWith":
                return str -> str.endsWith(lastCommand);
            case "Length":
                return str -> str.length() == Integer.parseInt(lastCommand);
        }

        return null;
    }
}
