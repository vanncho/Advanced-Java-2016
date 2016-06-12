import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_StudentsByGroup_WithoutClass {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map<String, Integer> mapOfStudents = new HashMap<>();

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

        mapOfStudents
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((name1, name2) -> {
                    String[] nameOne = name1.getKey().split("[\\s+]");
                    String oneFirstName = nameOne[0];

                    String[] nameTwo = name2.getKey().split("[\\s+]");
                    String twoFirstName = nameTwo[0];

                    return oneFirstName.compareTo(twoFirstName);
                })
                .forEach(student -> System.out.println(student.getKey()));
    }
}
