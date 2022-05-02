package lol.hub.codewars.java_functional_programming_part_1_the_beginning;

public class Student {
    public final String studentNumber;
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName, String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCommaName() {
        return lastName + ", " + firstName;
    }
}
