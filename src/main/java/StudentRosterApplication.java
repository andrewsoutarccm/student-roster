
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.andrewsoutar.cmp128.Utilities;
import com.andrewsoutar.cmp128.Utilities.GenericScanner;
import com.andrewsoutar.cmp128.Utilities.MenuAction;
import com.andrewsoutar.cmp128.Utilities.VoidFunction;

public class StudentRosterApplication {
    private GenericScanner kbdScanner;
    private final Student [] roster = new Student [20];

    private static final Node ROSTER_FIRST_STUDENT;
    static {
        try {
            ROSTER_FIRST_STUDENT =
                DocumentBuilderFactory.newInstance ().newDocumentBuilder ()
                .parse (new File (StudentRosterApplication.class
                                  .getClassLoader ()
                                  .getResource ("roster.xml")
                                  .getFile ()))
                .getDocumentElement ().getFirstChild ();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ExceptionInInitializerError (e);
        }
    }

    public StudentRosterApplication (GenericScanner kbdScanner) {
        this.kbdScanner = kbdScanner;

        Node currentStudent = ROSTER_FIRST_STUDENT;
        try {
            for (int i = 0; i < roster.length;
                 i++, currentStudent = currentStudent.getNextSibling ()) {

                while (currentStudent.getNodeType () == Node.TEXT_NODE) {
                    currentStudent = currentStudent.getNextSibling ();
                }

                roster [i] =
                    new Student (i + 1, currentStudent.getTextContent ());
            }
        } catch (NullPointerException e) {
            System.out.println ("Not enough students in roster.xml");
            throw (e);
        }
    }

    private void welcomeBanner () {
        Utilities.printBordered (new String [] {
                "Welcome to the Student Roster App. This program will allow "
                + "you to create and display a class roster."
            });
    }

    public void run () {
        Utilities.mainLoop (kbdScanner, new VoidFunction () {
                public void call () {
                    welcomeBanner ();
                }
            }, new MenuAction [] {
                new MenuAction () {
                    public String getName () {
                        return ("edit student data");
                    }
                    public Boolean call () {
                        for (Student student : roster) {
                            student.update (kbdScanner);
                        }
                        return (new Boolean (true));
                    }
                },
                new MenuAction () {
                    public String getName () {
                        return ("display roster");
                    }
                    public Boolean call () {
                        Utilities.clearScreen ();
                        welcomeBanner ();

                        String [] rosterStrings = new String [roster.length];
                        for (int i = 0; i < roster.length; i++) {
                            rosterStrings [i] = roster [i].formatEntry ();
                        }
                        Utilities.printBordered(rosterStrings, '@');
                        return (new Boolean (true));
                    }
                },
                new MenuAction () {
                    public String getName () {
                        return ("exit");
                    }
                    public Boolean call () {
                        return (Utilities.exitLoop (kbdScanner));
                    }
                }
            });
    }
}
