import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _08_WeakStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Students> listOfStudents = new LinkedList<>();

        while (true){
            String line = input.readLine();

            if (line.equals("END")){
                break;
            }

            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> marks = new ArrayList<>();

            for (int i = 2; i < tokens.length; i++) {
                int currMark = Integer.parseInt(tokens[i]);
                marks.add(currMark);
            }

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setMarks(marks);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(x -> {
                    return x.getMarks().stream().filter(m -> m <= 3).count() >= 2;
                })
                .forEach(name -> System.out.printf("%s %s%n", name.getFirstName(), name.getLastName()));
    }
}
