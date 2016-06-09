import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_ExcellentStudents {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Students> listOfStudents = new LinkedList<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String regex = "([A-Za-z]+)\\s+([A-Za-z]+)\\s(.+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            String firstName = "";
            String lastName = "";
            List<Integer> marks = new ArrayList<>();

            if (matcher.find()){
                firstName = matcher.group(1);
                lastName = matcher.group(2);
                String[] lineWithMarks = matcher.group(3).split("\\s+");

                for (int i = 0; i < lineWithMarks.length; i++) {
                    int currMark = Integer.parseInt(lineWithMarks[i]);
                    marks.add(currMark);
                }
            }

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setMarks(marks);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(marks -> {
                    return marks.getMarks().contains(6);
                })
                .forEach(n -> System.out.printf("%s %s%n", n.getFirstName(), n.getLastName()));
    }
}
