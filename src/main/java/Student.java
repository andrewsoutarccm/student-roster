
import com.andrewsoutar.cmp128.Utilities.GenericScanner;
import com.andrewsoutar.cmp128.Utilities.UnaryFunction;

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
        name = kbdScanner.<String, String> prompt
            (String.class,
             String.format
             ("Enter the name of student %02d [%s]", studentNumber, name),
             new UnaryFunction <String, String> () {
                public String call (String newName) {
                    newName = newName.trim ();
                    if (newName.isEmpty ()) {
                        return (name);
                    } else {
                        return (newName);
                    }
                }
            });
    }

    public String formatEntry () {
        return (String.format ("Student %02d: %s", studentNumber, name));
    }
}
