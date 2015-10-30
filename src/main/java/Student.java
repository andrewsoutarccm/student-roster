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

    public void update (Scanner kbdScanner) {
        System.out.format ("Enter the name of student %02d: [%s] ",
                           studentNumber, name);
        String newName = kbdScanner.nextLine ().trim ();

        if (!(newName.isEmpty ())) {
            name = newName;
        }
    }

    public String formatEntry () {
        return (String.format ("Student %02d: %s", studentNumber, name));
    }
}
