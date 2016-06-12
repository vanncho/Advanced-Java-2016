import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _04_SortStudents_WithoutClasses {
    public static void main(String[] args) throws IOException{

        List<String> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;

            while (!Objects.equals(line = br.readLine(), "END")) {

                students.add(line);
            }
        }

        students
                .stream()
                .sorted((n1, n2) -> {
                    String[] nameOneTokens = n1.split("[\\s]+");
                    String oneFirstName = nameOneTokens[0];
                    String oneLastName = nameOneTokens[1];

                    String[] nameTwoTokens = n2.split("[\\s]+");
                    String twoFirstName = nameTwoTokens[0];
                    String twoLastName = nameTwoTokens[1];

                    if (oneLastName.equals(twoLastName)){
                        return twoFirstName.compareTo(oneFirstName);
                    }

                    return oneLastName.compareTo(twoLastName);
                })
                .forEach(name -> System.out.println(name));
    }
}
