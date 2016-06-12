import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> listOfSpecialties = new ArrayList<>();
        List<StudentsClass> listOfStudents = new ArrayList<>();

        while (true){
            String line = br.readLine();

            if (line.equals("END")){
                break;
            }

            while (!line.equals("Students:")){
                String[] specialtiesTokens = line.split("[\\s]+");
                String specialtie = specialtiesTokens[0] + " " + specialtiesTokens[1];
                int facultyNumber = Integer.valueOf(specialtiesTokens[2]);

                StudentSpecialty specialty = new StudentSpecialty();
                specialty.setSpecialityName(specialtie);
                specialty.setFNumber(facultyNumber);

                listOfSpecialties.add(specialty);
                line = br.readLine();
            }

            boolean isEnd = false;
            while (true){
                line = br.readLine();

                if (line.equals("END")){
                    isEnd = true;
                    break;
                }
                String[] studentsTokens = line.split("[\\s]+");
                String studentName = studentsTokens[1] + " " + studentsTokens[2];
                int studentNumber = Integer.valueOf(studentsTokens[0]);

                StudentsClass student = new StudentsClass();
                student.setName(studentName);
                student.setFacNum(studentNumber);

                listOfStudents.add(student);
            }

            if (isEnd){
                break;
            }
        }

        List<String>  collectedData = new ArrayList<>();
        listOfStudents.stream().flatMap(student -> listOfSpecialties.stream().filter(speciality -> {
            if (student.getFacNum() == speciality.getFNumber()){
                collectedData.add(String.format("%s %d %s", student.getName(), student.getFacNum(), speciality.getSpecialityName()));
            }

            return student.getFacNum() == speciality.getFNumber();
        })).collect(Collectors.toList());

        collectedData
                .stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .forEach(System.out::println);
    }
}

class StudentsClass {
    private String name;
    private int facNum;

    public String getName() {
        return name;
    }

    public int getFacNum() {
        return facNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacNum(int facNum) {
        this.facNum = facNum;
    }
}

class StudentSpecialty {
    private String specialityName;
    private int fNumber;

    public String getSpecialityName() {
        return specialityName;
    }

    public int getFNumber() {
        return fNumber;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public void setFNumber(int fNumber) {
        this.fNumber = fNumber;
    }
}