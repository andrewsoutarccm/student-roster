import java.util.Scanner;

public class Student {
    private int studentNumber;

    private String name;
    public String getName () {
        return (name);
    }

    public Student (Scanner kbdScanner, int studentNumber,
                    Student prototype) {
        this.studentNumber = studentNumber;
        while (true) {
            System.out.format ("Enter the name of student %02d: %s",
                               studentNumber,
                               ((prototype != null) ?
                                String.format ("[%s] ", prototype.getName ()) :
                                ""));
            String input = kbdScanner.nextLine ().trim ();
            if (input.isEmpty ()) {
                if (prototype != null) {
                    name = prototype.getName ();
                    break;
                } else {
                    System.out.println ("Cannot use an empty name, try again.");
                }
            } else {
                name = input;
                break;
            }
        }
    }

    public String formatEntry () {
        return (String.format ("Student %02d: %s", studentNumber, getName ()));
    }
}
