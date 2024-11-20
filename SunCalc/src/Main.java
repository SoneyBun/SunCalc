import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String terms = "";
        Storing store;
        Operation answer;

        try {
            if(Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI("https://bit.ly/SunCalcFunctions");
                desktop.browse(uri);
            }
            else {
                System.out.println("Desktop is not supported on this system.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("SunCalc\n\nSunCalc is a calculator for math, not to get information about sun and moon times.\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list: https://bit.ly/SunCalcFunctions\nType esc to quit");

        while(!(terms.equalsIgnoreCase("esc"))) {
            terms = scan.nextLine();

            if(terms.equalsIgnoreCase("esc")) {
                System.out.println("Thank you for using SunCalc");
                System.exit(0);
            }

            store = new Storing((terms));
            answer = new Operation(store.getNum1(), store.getNum2(), store.getFunction());

            System.out.println(answer);
        }
    }
}
