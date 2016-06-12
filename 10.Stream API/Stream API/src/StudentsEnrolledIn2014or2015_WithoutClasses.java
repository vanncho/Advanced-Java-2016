import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsEnrolledIn2014or2015_WithoutClasses {
    public static void main(String[] args) throws IOException {


        Map<Integer, List<Integer>> studentInfo = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String line = null;

            while (!Objects.equals(line = br.readLine(), "END")){

                String[] tokens = line.split("[\\s]+");
                int number = Integer.valueOf(tokens[0]);
                List<Integer> marks = new ArrayList<>();

                for (int i = 1; i < tokens.length; i++) {
                    int mark = Integer.valueOf(tokens[i]);
                    marks.add(mark);
                }

                studentInfo.put(number, marks);
            }
        }

        studentInfo.entrySet()
                .stream()
                .filter(marks -> {
                    int year = marks.getKey() % 100;

                    if (year == 14 || year == 15){
                        return true;
                    } else {
                        return false;
                    }
                })
                .forEach(mark -> System.out.println(mark.getValue().toString().substring(1, mark.getValue().toString().length() -1).replaceAll(", ", " ")));
    }
}
