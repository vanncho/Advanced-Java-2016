import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _08_WeakStudents_WithoutClasses {
    public static void main(String[] args) throws IOException {

        Map<String, List<Integer>> studentsInfo = new LinkedHashMap<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String line = null;

            while (!Objects.equals(line = br.readLine(), "END")){

                String[] tokens = line.split("[\\s]+");
                String name = tokens[0] + " " + tokens[1];

                List<Integer> marks = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    int mark = Integer.valueOf(tokens[i]);
                    marks.add(mark);
                }

                studentsInfo.put(name, marks);
            }
        }

        studentsInfo.entrySet()
                .stream()
                .filter(student -> {
                    List<Integer> marks = student.getValue();

                    int count = 0;
                    for (int i = 0; i < marks.size(); i++) {
                        if (marks.get(i) <= 3){
                            count++;
                        }
                    }
                    if (count >= 2){
                        return true;
                    } else {
                        return false;
                    }
                })
                .forEach(name -> {
                    String[] tokens = name.getKey().split("[\\s]+");
                    String fullName = tokens[0] + " " + tokens[1];
                    System.out.println(fullName);
                });
    }
}
