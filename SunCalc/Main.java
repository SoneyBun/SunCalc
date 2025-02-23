import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String terms = "";
        Storing store;
        Operation answer = new Operation(0, 0, "+");
        boolean testing = false;
        int choice = -1;

        if (!testing) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://bit.ly/SunCalcFunctions");
                    desktop.browse(uri);
                } else {
                    System.out.println("Desktop is not supported on this system.");
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }

        System.out.println("SunCalc\n\nSunCalc is a calculator for math, not to get information about sun and moon times.\nSunCalc uses Reverse Polish Notation\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list: https://bit.ly/SunCalcFunctions\nType esc to quit\n");

        while(!(terms.equalsIgnoreCase("esc"))) {
            terms = scan.nextLine();

            if(terms.equalsIgnoreCase("esc") || terms.equalsIgnoreCase("escape") || terms.isEmpty()) {
                System.out.println("Thank you for using SunCalc");
                System.exit(0);
            }
            else if(terms.equalsIgnoreCase("help")) {
                System.out.println("For any assistance, join the Discord server: https://bit.ly/SunCode\nView the Github repository at: https://github.com/SoneyBun/SunCalc");
            }
            else if(terms.equalsIgnoreCase("health")) {
                System.out.println("You will not be able to access the regular version of SunCalc\nDo NOT make medical decisions based off of any information given from this calculator. This is nothing but a coding project.");

                try {
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        URI uri = new URI("https://www.unitconverters.net");
                        desktop.browse(uri);
                    } else {
                        System.out.println("Desktop is not supported on this system.");
                    }
                } catch (Exception e) {
                    e.fillInStackTrace();
                }

                Health.getMeasurementSystem();

                while(choice != 0) {
                    System.out.println("What would you like to do?\n(1) - Calculate Body Mass Index (BMI)\n(2) - Calculate Estimated Height");
                    try {
                        choice = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Option.");
                    }

                    if(choice == 1) {
                        Health.calculateBMI();
                    } else {
                        Health.estimateHeight();
                    }
                }
            } else {
                store = new Storing(terms, answer.getAnswer(), answer.getAnswer2());
                answer = new Operation(store.getNum1(), store.getNum2(), store.getFunction());

                System.out.println(answer);
            }
        }
    }
}