import java.util.Scanner;

public class Health {
    static double h, h2, w, bmi;
    static boolean g, ms;
    static Scanner scan = new Scanner(System.in);

    public static void getMeasurementSystem() {
        System.out.print("Enter Measurement System (Metric/Imperial): ");
        char ems = scan.nextLine().toLowerCase().charAt(0);
        ms = ems == 'm';
    }

    public static void calculateBMI() {
        if(ms) {
            System.out.print("Height (Meters): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.print("Weight (Kilograms): ");
            w = Double.parseDouble(scan.nextLine());
            bmi = w / Math.pow(h, 2);
        } else {
            System.out.print("Height (Inches): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.print("Weight (Pounds): ");
            w = Double.parseDouble(scan.nextLine());
            bmi = 703 * w / Math.pow(h, 2);
        }

        if(bmi < 18.5) {
            System.out.println("BMI (Body Mass Index): " + bmi + "\nWeight Class: Underweight" + "\n");
        }
        else if(bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI (Body Mass Index): " + bmi + "\nWeight Class: Normal" + "\n");
        }
        else if(bmi >= 25 && bmi < 30) {
            System.out.println("BMI (Body Mass Index): " + bmi + "\nWeight Class: Overweight" + "\n");
        }
        else {
            System.out.println("BMI (Body Mass Index): " + bmi + "\nWeight Class: Obese" + "\n");
        }
    }

    public static void estimateHeight() {
        System.out.print("Enter Your Biological Gender (Male/Female): ");
        char eg = scan.nextLine().toLowerCase().charAt(0);
        g = eg == 'm';

        if(ms) {
            System.out.print("Mother's Height (Centimeters): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.print("Father's Height (Centimeters): ");
            h2 = Double.parseDouble(scan.nextLine());

            if(g) {
                System.out.println("Estimated Height: " + ((h + h2 + 13)/2) + "cm.");
            } else {
                System.out.println("Estimated Height: " + ((h + h2 - 13)/2) + "cm.");
            }
        } else {
            System.out.print("Mother's Height (Inches): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.println("Father's Height (Inches): ");
            h2 = Double.parseDouble(scan.nextLine());

            if(g) {
                System.out.println("Estimated Height: " + ((h + h2 + 5)/2) + "in.");
            } else {
                System.out.println("Estimated Height: " + ((h + h2 - 5)/2) + "in.");
            }
        }
    }
}
