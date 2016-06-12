import java.util.*;

public class _02_StudentsByFirstAndLastName_WithoutClasses {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];

            names.add(name);
        }

        names.stream()
                .filter(n -> {
                    String[] fullName = n.split("[\\s]+");
                    String firstName = fullName[0];
                    String lastName = fullName[1];

                    return firstName.compareTo(lastName) < 0;
                })
                .forEach(n -> System.out.println(n));
    }
}
