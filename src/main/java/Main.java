import com.andrewsoutar.cmp128.Utilities;
import com.andrewsoutar.cmp128.Utilities.GenericScanner;

public class Main {
    public static void main (String [] args) {
        Utilities.printHeader(Utilities.ProgramType.LAB, 3, "Student Roster");
        StudentRosterApplication app =
            new StudentRosterApplication (new GenericScanner ());
        app.run ();
    }
}
