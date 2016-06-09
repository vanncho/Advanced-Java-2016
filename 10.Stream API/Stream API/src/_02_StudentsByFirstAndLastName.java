import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_StudentsByFirstAndLastName {
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

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(student -> System.out.printf("%s %s%n", student.getFirstName(), student.getLastName()));
    }
}

