import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _06_FilterStudentsByPhone {
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
            String phone = tokens[2];

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setPhone(phone);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(email -> {
                    return email.getPhone().startsWith("02") || email.getPhone().startsWith("+3592");
                })
                .forEach(name -> System.out.printf("%s %s%n", name.getFirstName(), name.getLastName()));

    }
}

