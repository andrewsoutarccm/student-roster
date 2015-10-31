
import com.andrewsoutar.cmp128.Utilities.GenericScanner;

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

    public void update (GenericScanner kbdScanner) {
        System.out.format ("Enter the name of student %02d: [%s] ",
                           studentNumber, name);
        String newName = kbdScanner.<String>next (String.class).trim ();

        if (!(newName.isEmpty ())) {
            name = newName;
        }
    }

    public String formatEntry () {
        return (String.format ("Student %02d: %s", studentNumber, name));
    }
}
