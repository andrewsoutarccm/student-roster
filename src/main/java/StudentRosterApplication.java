import java.util.InputMismatchException;
import java.util.Scanner;

import com.andrewsoutar.cmp128.Utilities;

public class StudentRosterApplication {
    private Scanner kbdScanner;
    private final Student [] roster = new Student [20];

    public StudentRosterApplication (Scanner kbdScanner) {
        this.kbdScanner = kbdScanner;
    }

    private void welcomeBanner () {
        Utilities.printBordered (new String [] {
                "Welcome to the Student Roster App. This program will allow "
                + "you to create and display a class roster."
            });
    }

    private void enterStudentData () {
        for (int i = 0; i < roster.length; i++) {
            roster [i] = new Student (kbdScanner, i + 1, roster [i]);
        }
    }

    private void displayRoster () {
        Utilities.clearScreen ();
        welcomeBanner ();

        String [] rosterStrings = new String [roster.length];
        for (int i = 0; i < roster.length; i++) {
            rosterStrings [i] = roster [i].formatEntry ();
        }
        Utilities.printBordered(rosterStrings, '@');
    }

    public void run () {
        welcomeBanner ();
        mainLoop:
        while (true) {
            System.out.println ("Press 1 to enter student data.");
            System.out.println ("Press 2 to display roster.");
            System.out.println ("Press 3 to exit application.");
            System.out.print ("Choice: ");

            int choice;
            try {
                choice = new Scanner (kbdScanner.nextLine ()).nextInt ();
            } catch (InputMismatchException e) {
                System.out.println ("Please enter a number.");
                System.out.println ();
                continue;
            }

            switch (choice) {
            case 1:
                enterStudentData ();
                break;
            case 2:
                try {
                    displayRoster ();
                } catch (NullPointerException e) {
                    System.out.println ("You have not created the roster yet!");
                    System.out.println ();
                }
                break;
            case 3:
            exitLoop:
                while (true) {
                    System.out.print ("Are you sure you want to exit? [y/N] ");
                    switch (kbdScanner.nextLine ().toLowerCase ()) {
                    case "":
                    case "n":
                    case "no":
                        break exitLoop;
                    case "y":
                    case "yes":
                        break mainLoop;
                    }
                }
                System.out.println ();
                break;
            default:
                System.out.println ("Please enter a number between 1 and 3.");
                System.out.println ();
            }
        }
    }
}
