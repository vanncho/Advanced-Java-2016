import java.util.LinkedList;
import java.util.Scanner;

public class _03_StudentsByAge {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Students> listOfStudents = new LinkedList<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(age -> age.getAge() >= 18 && age.getAge() <= 24)
                .forEach(student -> System.out.printf("%s %s %d%n", student.getFirstName(), student.getLastName(), student.getAge()));
    }
}

