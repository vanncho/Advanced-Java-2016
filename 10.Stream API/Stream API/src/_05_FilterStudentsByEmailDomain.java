import java.util.LinkedList;
import java.util.Scanner;

public class _05_FilterStudentsByEmailDomain {
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
            String mail = tokens[2];

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(mail);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(mail -> mail.getEmail().endsWith("@gmail.com"))
                .forEach(name -> System.out.printf("%s %s%n", name.getFirstName(), name.getLastName()));
    }
}

