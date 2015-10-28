import java.util.Scanner;

import com.andrewsoutar.cmp128.Utilities;

public class Main {
    public static void main (String [] args) {
        Utilities.printHeader(Utilities.ProgramType.LAB, 3, "Student Roster");
        StudentRosterApplication app =
            new StudentRosterApplication (new Scanner (System.in));
        app.run ();
    }
}
