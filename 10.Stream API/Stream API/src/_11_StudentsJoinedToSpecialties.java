import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> listOfSpecialties = new ArrayList<>();
        List<Students> listOfStudents = new ArrayList<>();

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
                specialty.setSpecialtyName(specialtie);
                specialty.setFacultyNumber(facultyNumber);

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
                int studentNumber = Integer.valueOf(studentsTokens[0]);
                String studentName = studentsTokens[1] + " " + studentsTokens[2];

                Students student = new Students();
                student.setFullName(studentName);
                student.setFacultyNumber(studentNumber);

                listOfStudents.add(student);
            }

            if (isEnd){
                break;
            }
        }


        // ПРОЧЕЛ СЪМ ВХОДА, ОСТАВА само логиката!!!
    }
}

class StudentSpecialty {
    private String specialtyName;
    private int facultyNumber;

    public String getSpecialtyName() {
        return specialtyName;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }
}