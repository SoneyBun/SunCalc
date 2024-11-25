import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;
@SuppressWarnings("all")

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String terms = "";
        Storing store;
        Operation answer = new Operation(0, 0, "+");

        System.out.println("SunCalc\n\nSunCalc is a calculator for math, not to get information about sun and moon times.\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list: https://bit.ly/SunCalcFunctions\nType esc to quit\n");

        while(!(terms.equalsIgnoreCase("esc"))) {
            terms = scan.nextLine();

            if(terms.equalsIgnoreCase("esc") || terms.equalsIgnoreCase("escape")) {
                System.out.println("Thank you for using SunCalc");
                System.exit(0);
            }

            store = new Storing(terms, answer.getAnswer(), answer.getAnswer2());
            answer = new Operation(store.getNum1(), store.getNum2(), store.getFunction());

            System.out.println(answer);
        }
    }
}
