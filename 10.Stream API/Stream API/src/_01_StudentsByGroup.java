import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_StudentsByGroup {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Students> listOfStudents = new ArrayList<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int group = Integer.parseInt(tokens[2]);
            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGroup(group);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(group -> group.getGroup() == 2)
                .sorted((n1, n2) -> n1.getFirstName().compareTo(n2.getFirstName()))
                .forEach(student -> System.out.printf("%s %s%n", student.getFirstName(), student.getLastName()));
    }
}