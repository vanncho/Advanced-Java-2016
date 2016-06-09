import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_StudentsEnrolledIn2014or2015 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Students> listOfStudents = new LinkedList<>();

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String regex = "(\\d+)\\s+(.*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            String facultyNumber = "";
            String lineWithMarks = "";
            List<Integer> marks = new ArrayList<>();

            if (matcher.find()){
                facultyNumber = matcher.group(1);
                lineWithMarks = matcher.group(2);
                String[] marksAsString = lineWithMarks.split("\\s+");

                for (int i = 0; i < marksAsString.length; i++) {
                    int currMark = Integer.parseInt(marksAsString[i]);
                    marks.add(currMark);
                }
            }

            Students student = new Students();
            student.setfNumber(facultyNumber);
            student.setMarks(marks);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .filter(x -> x.getfNumber().endsWith("14") || x.getfNumber().endsWith("15"))
                .map(x -> x.getMarks())
                .forEach(m -> System.out.println(m.toString().substring(1, m.toString().length() - 1).replaceAll(", ", " ")));
    }
}
