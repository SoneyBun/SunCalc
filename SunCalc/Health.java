import java.util.Scanner;

public class Health {
    static double h, h2, w, bmi;
    static float bf;
    static boolean g, ms;
    static int a, gNum;
    static Scanner scan = new Scanner(System.in);

    public static void getMeasurementSystem() {
        System.out.print("Enter Measurement System (Metric/Imperial): ");
        char ems = scan.nextLine().toLowerCase().charAt(0);
        ms = ems == 'm';
    }

    public static void calculateBMI() {
        if(ms) {
            System.out.print("Height (Centimeters): ");
            h = Double.parseDouble(scan.nextLine()) / 100;
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
            System.out.println("BMI (Body Mass Index): " + bmi + " kilograms/square meters\nWeight Class: Underweight" + "\n");
        }
        else if(bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI (Body Mass Index): " + bmi + " kilograms/square meters\nWeight Class: Normal" + "\n");
        }
        else if(bmi >= 25 && bmi < 30) {
            System.out.println("BMI (Body Mass Index): " + bmi + " kilograms/square meters\nWeight Class: Overweight" + "\n");
        }
        else {
            System.out.println("BMI (Body Mass Index): " + bmi + " kilograms/square meters\nWeight Class: Obese" + "\n");
        }
    }

    public static void calculateBMR() {
        System.out.print("Biological Gender (Male/Female): ");
        char eg = scan.nextLine().toLowerCase().charAt(0);
        g = eg == 'm';

        if(ms) {
            System.out.print("Height (Centimeters): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.print("Weight (Kilograms): ");
            w = Double.parseDouble(scan.nextLine());
        } else {
            System.out.print("Height (Inches): ");
            h = Double.parseDouble(scan.nextLine()) * 2.54;
            System.out.print("Weight (Pounds): ");
            w = Double.parseDouble(scan.nextLine()) * .453592;
        }
        System.out.print("Age (Years): ");
        a = Integer.parseInt(scan.nextLine());
        if(a < 15 || a > 80) {
            System.out.println("Results are more accurate within the age range 15-80.");
        }
        System.out.print("Body Fat Percentage (Integer): ");
        bf = Float.parseFloat(scan.nextLine()) / 100;

        System.out.println("BMR (Basal Metabolic Rate):");

        gNum = g ? 5 : -161;
        System.out.println("Mifflin-St Jeor Equation: " + ((10 * w) + (6.25 * h) - (5 * a) + gNum) + " calories/day");

        if(g) {
            System.out.println("Revised Harris-Benedict Equation: " + ((13.397 * w) + (4.799 * h) - (5.677 * a) + 88.362) + " calories/day");
        } else {
            System.out.println("Revised Harris-Benedict Equation: " + ((9.247 * w) + (3.098 * h) - (4.33 * a) + 447.593) + " calories/day");
        }

        System.out.println("Katch-McArdle Formula: " + (370 + (21.6 * (1 - bf) * w)) + " calories/day");
    }

    public static void estimateHeight() {
        System.out.print("Biological Gender (Male/Female): ");
        char eg = scan.nextLine().toLowerCase().charAt(0);
        g = eg == 'm';

        if(ms) {
            System.out.print("Mother's Height (Centimeters): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.print("Father's Height (Centimeters): ");
            h2 = Double.parseDouble(scan.nextLine());

            gNum = g ? 13 : -13;
            System.out.println("Estimated Height: " + ((h + h2 + gNum)/2) + "cm.");
        } else {
            System.out.print("Mother's Height (Inches): ");
            h = Double.parseDouble(scan.nextLine());
            System.out.println("Father's Height (Inches): ");
            h2 = Double.parseDouble(scan.nextLine());

            gNum = g ? 5 : -5;
            System.out.println("Estimated Height: " + ((h + h2 + gNum)/2) + "in.");
        }
    }
}
