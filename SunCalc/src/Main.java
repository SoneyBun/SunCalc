import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("SunCalc\n\nSunCalc is a calculator for math, not to get information about sun and moon times.\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list");
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
        String terms = scan.nextLine();

        Storing store = new Storing((terms));
        Operation answer = new Operation(store.getNum1(), store.getNum2(), store.getFunction());

        System.out.println(answer);
    }
}
