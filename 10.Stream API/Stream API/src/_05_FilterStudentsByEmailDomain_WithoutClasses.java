import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class _05_FilterStudentsByEmailDomain_WithoutClasses {
    public static void main(String[] args) throws IOException {

        LinkedList<String> students = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = null;

            while (!Objects.equals(line = br.readLine(), "END")){

                students.add(line);
            }
        }

        students
                .stream()
                .filter(student -> {
                    String[] tokens = student.split("[\\s]+");
                    String mail = tokens[2];

                    return mail.endsWith("@gmail.com");
                })
                .forEach(name -> {
                    String[] tokens = name.split("[\\s]+");
                    System.out.println(tokens[0] + " " + tokens[1]);
                });
    }
}
