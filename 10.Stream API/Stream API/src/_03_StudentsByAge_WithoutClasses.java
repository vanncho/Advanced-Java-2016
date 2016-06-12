import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_StudentsByAge_WithoutClasses {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map<String, Integer> mapOfStudents = new LinkedHashMap<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            mapOfStudents.put(name, group);
        }

        mapOfStudents.entrySet()
                .stream()
                .filter(group -> group.getValue() >= 18 && group.getValue() <= 24)
                .forEach(student -> System.out.printf("%s %d%n", student.getKey(), student.getValue()));
    }
}
