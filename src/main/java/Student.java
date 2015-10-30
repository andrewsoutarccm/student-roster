import java.util.Scanner;

public class Student {
    private int studentNumber;
    public int getStudentNumber () {
        return (studentNumber);
    };

    private String name;
    public String getName () {
        return (name);
    }

    public Student (int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public Student (Scanner kbdScanner, Student prototype) {
        this.studentNumber = prototype.getStudentNumber ();

        System.out.format ("Enter the name of student %02d: [%s] ",
                                studentNumber,
                                prototype.getName ());
        name = kbdScanner.nextLine ().trim ();

        if (name.isEmpty ()) {
            name = prototype.getName ();
        }
    }

    public String formatEntry () {
        return (String.format ("Student %02d: %s", studentNumber, name));
    }
}
