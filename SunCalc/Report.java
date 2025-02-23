import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class Report {
    private final String reason;
    private final int severity;
    static Scanner scan = new Scanner(System.in);

    public Report(String reason, int severity) {
        this.reason = reason;
        this.severity = severity;
    }

    public String toString() {
        if(severity >= 3) {
            try {
                if (Desktop.isDesktopSupported()) {
                    System.out.println("Will you allow SunCalc to open Discord?");
                    if(agreement(scan.nextLine())) {
                        Desktop desktop = Desktop.getDesktop();
                        URI uri = new URI("https://discord.gg/NWysrrA5Vf");
                        desktop.browse(uri);
                    }
                } else {
                    System.out.println("Desktop is not supported on this system.");
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return reason + " (Severity " + severity + ")";
    }

    public static boolean agreement(String str) {
        str = str.toLowerCase();
        char ch = str.charAt(0);
        return ch == 't' || ch == 'y' || ch == 'a' || ch == '1';
    }
}
