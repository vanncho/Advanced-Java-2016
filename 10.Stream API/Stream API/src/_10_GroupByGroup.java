import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.Objects;
        import java.util.stream.Collectors;

public class _10_GroupByGroup {
    public static void main(String[] args) throws IOException {


        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){
            List<Students> listOfStudents = new ArrayList<>();
            String line = null;

            while (!Objects.equals(line = input.readLine(), "END")){

                String[] tokens = line.split("[\\s]+");
                String firstName = tokens[0];
                String lastName = tokens[1];
                int group = Integer.valueOf(tokens[2]);

                Students student = new Students();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setGroup(group);

                listOfStudents.add(student);
            }

            listOfStudents
                    .stream()
                    .collect(Collectors.groupingBy(Students::getGroup))
                    .forEach((groupNumber, group) -> {
                        System.out.printf("%d - ", groupNumber);
                        System.out.println(String.join(" ", group.toString()).replaceAll("[\\[\\]]", ""));
                    });
        }
    }
}
