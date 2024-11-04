import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("SunCalc\n\nEnter your terms in the format\nN1 N2 F\nOr\nN1 F\nFor a list of functions, view the following list https://bit.ly/SunCalcFunctions");
        String terms = scan.nextLine();

        Storing store = new Storing((terms));
        Operation answer = new Operation(store.getNum1(), store.getNum2(), store.getFunction());

        System.out.println(answer);
    }
}
