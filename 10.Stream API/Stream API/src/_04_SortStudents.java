import java.util.LinkedList;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class _04_SortStudents {
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

            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);

            listOfStudents.add(student);
        }

        listOfStudents.stream()
                .sorted((st1, st2) -> {
                    int res = st1.getLastName().compareTo(st2.getLastName());
                    if (res == 0){
                        res = st2.getFirstName().compareTo(st1.getFirstName());
                    }
                    return res;
                })
                .forEach(name -> System.out.printf("%s %s%n", name.getFirstName(), name.getLastName()));

    }
}

