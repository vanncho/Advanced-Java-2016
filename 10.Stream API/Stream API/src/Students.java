import java.util.List;

class Students{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String fNumber;
    private int group;
    private int age;
    private List<Integer> marks;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getfNumber() {
        return fNumber;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public int getGroup() {
        return group;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getFirstName(), getLastName());
    }
}
