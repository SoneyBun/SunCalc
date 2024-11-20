import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String terms = "";
        Storing store;
        Operation answer;

        System.out.println("This is the public testing version for SunCalc. Expect Bugs and older versions due to CodeHS limitations.\nSunCalc\n\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list https://bit.ly/SunCalcFunctions\nType esc to quit");
        
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
