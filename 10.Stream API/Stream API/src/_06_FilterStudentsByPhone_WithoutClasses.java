import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _06_FilterStudentsByPhone_WithoutClasses {
    public static void main(String[] args) throws IOException {

        List<String> students = new ArrayList<>(); // ? Linked ?

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String line = null;

            while (!Objects.equals(line = br.readLine(), "END")){

                students.add(line);
            }
        }

        students
                .stream()
                .filter(student -> {
                    String[] tokens = student.split("[\\s]+");
                    String phone = tokens[2];

                    return phone.startsWith("02") || phone.startsWith("+3592");
                })
                .forEach(name -> {
                    String[] tokens = name.split("[\\s]+");
                    String fullName = tokens[0] + " " + tokens[1];

                    System.out.println(fullName);
                });
    }
}
