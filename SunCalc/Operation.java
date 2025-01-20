import java.lang.Math;
import java.math.BigInteger;

public class Operation {
    private final double n1, n2;
    private final String fn;
    private double answer = 0, answer2 = 0;

    public Operation(double n1, double n2, String fn) {
        this.n1 = n1;
        this.n2 = n2;
        this.fn = fn;
    }

    private final Report unknownFunction = assignReport("Error - Unknown Function");
    private final Report undefinedDivideByZero = assignReport("Undefined - Dividing By Zero");
    private final Report undefinedFactorialOfANegative = assignReport("Undefined - Factorial Of A Negative");
    private final Report factorialOfADouble = assignReport("Error - Factorial Of A Double");
    private final Report rootOfANegative = assignReport("Error - Root Of A Negative");
    private final Report undefinedNegativeBase = assignReport("Undefined - Negative Base");

    public Report assignReport(String reason) {
        return new Report(reason);
    }

    public String toString() {
        switch (fn.toLowerCase()) {
            case "+", "add", "plus" :
                answer = (n1 + n2);
                answer2 = 0;
                return (n1 + " + " + n2 + " = " + answer);
            case "++", "increment" :
                answer = (n1 + 1);
                answer2 = 0;
                return (n1 + "++ = " + answer);
            case "-", "subtract", "minus" :
                answer = (n1 - n2);
                answer2 = 0;
                return (n1 + " - " + n2 + " = " + answer);
            case "--", "decrement" :
                answer = (n1 - 1);
                answer2 = 0;
                return (n1 + "-- = " + answer);
            case "*", "multiply", "times", "mult" :
                answer = (n1 * n2);
                answer2 = 0;
                return (n1 + " * " + n2 + " = " + answer);
            case "/", "divide", "div" :
                answer = (n1 / n2);
                answer2 = 0;
                if(n2 != 0) {
                    return (n1 + " / " + n2 + " = " + answer);
                }
                return ("" + undefinedDivideByZero);
            case "//", "floordiv" :
                answer = (int) (n1 / n2);
                answer2 = 0;
                if(n2 != 0) {
                    return (n1 + " // " + n2 + " = " + answer);
                }
                return ("" + undefinedDivideByZero);
            case ">" : return ("" + (n1 > n2));
            case ">=" : return ("" + (n1 >= n2));
            case "<" : return ("" + (n1 < n2));
            case "<=" : return ("" + (n1 <= n2));
            case "=", "==" : return ("" + (n1 == n2));
            case "!=" : return ("" + (n1 != n2));
            case "max", "maximum" :
                answer = Math.max(n1, n2);
                answer2 = 0;
                return ("" + answer);
            case "min", "minimum" :
                answer = Math.min(n1, n2);
                answer2 = 0;
                return ("" + answer);
            case "%", "modulus", "mod" :
                answer = (n1 % n2);
                answer2 = (n2 % n1);
                return (n1 + " % " + n2 + " = " + answer + "\n" + n2 + " % " + n1 + " = " + answer2);
            case "||", "abval" :
                answer = Math.abs(n1);
                answer2 = 0;
                return ("|" + n1 + "| = " + answer);
            case "bmi" :
                String weight;
                answer = (n2 / Math.pow(n1, 2)) * 703;
                answer2 = 0;

                if(answer < 18.5) {
                    weight = "Underweight";
                }
                else if(answer >= 18.5 && answer < 25) {
                    weight = "Normal";
                }
                else if(answer >= 25 && answer < 30) {
                    weight = "Overweight";
                } else {
                    weight = "Obese";
                }
                return ("BMI: " + answer + "kg/m^2\nWeight Class: " + weight);
            case "!", "factorial" :
                BigInteger factorial = BigInteger.ONE;
                BigInteger factorialTruncatedN1 = BigInteger.ONE;
                BigInteger factorialRoundedN1 = BigInteger.ONE;
                if(n1 >= 0) {
                    if(n1 == (int) n1) {
                        for(int i = 1; i <= (int) n1; i++) {
                            factorial = factorial.multiply(BigInteger.valueOf(i));
                        }
                        answer = factorial.doubleValue();
                        answer2 = 0;
                        return (n1 + "! = " + answer);
                    }
                    else {
                        int truncatedN1 = (int) (n1);
                        int roundedN1 = (int) Math.round(n1);

                        for(int i = 1; i <= truncatedN1; i++) {
                            factorialTruncatedN1 = factorialTruncatedN1.multiply(BigInteger.valueOf(i));
                        }

                        for(int i = 1; i <= roundedN1; i++) {
                            factorialRoundedN1 = factorialRoundedN1.multiply(BigInteger.valueOf(i));
                        }
                        answer = factorialTruncatedN1.doubleValue();
                        if(truncatedN1 != roundedN1) {
                            answer2 = factorialRoundedN1.doubleValue();
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated is \n" + truncatedN1 + "! = " + answer + "\nThe factorial of " + n1 + " rounded is \n" + roundedN1 + "! = " + answer2);
                        }
                        else {
                            answer2 = 0;
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated/rounded is \n" + truncatedN1 + "! = " + answer);
                        }
                    }
                }
                else {
                    if(n1 == (int) n1) {
                        for(int i = 1; i <= (int) (n1 * -1); i++) {
                            factorial = factorial.multiply(BigInteger.valueOf(i));
                        }
                        answer = factorial.doubleValue();
                        answer2 = 0;
                        return (undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive is \n" + (n1 * -1) + "! = " + answer);
                    }

                    int positiveTruncatedN1 = (int) (n1 * -1);
                    int positiveRoundedN1 = (int) Math.round(n1 * -1);

                    BigInteger factorialPositiveTruncatedN1 = BigInteger.ONE;
                    BigInteger factorialPositiveRoundedN1 = BigInteger.ONE;

                    for(int i = 1; i <= positiveTruncatedN1; i++) {
                        factorialPositiveTruncatedN1 = factorialPositiveTruncatedN1.multiply(BigInteger.valueOf(i));
                    }

                    for(int i = 1; i <= positiveRoundedN1; i++) {
                        factorialPositiveRoundedN1 = factorialPositiveRoundedN1.multiply(BigInteger.valueOf(i));
                    }
                    answer = factorialPositiveTruncatedN1.doubleValue();
                    if(positiveTruncatedN1 != positiveRoundedN1) {
                        answer2 = factorialPositiveRoundedN1.doubleValue();
                        return (factorialOfADouble + "\n" + undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive and truncated is \n" + positiveTruncatedN1 + "! = " + answer + "\nThe factorial of " + n1 + " positive and rounded is \n" + positiveRoundedN1 + "! = " + answer2);
                    }
                    else {
                        answer2 = 0;
                        return (factorialOfADouble + "\n" + undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive and truncated/rounded is \n" + positiveTruncatedN1 + "! = " + answer);
                    }
                }
            case "^", "exponent", "power", "exp", "pow" :
                answer = Math.pow(n1, n2);
                return (n1 + "^" + n2 + " = " + answer);
            case "rt", "root" :
                answer2 = 0;
                if(n1 >= 0) {
                    answer = Math.pow(n1, (1 / n2));
                    return (n1 + "^(1.0/" + n2 + ") = " + answer);
                }
                else {
                    return (rootOfANegative.toString());
                }
            case "apcon" :
                answer = Irrational.APCON;
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.APCON);
                    return (n1 + "apcon = " + answer + "\n" + n2 + "apcon = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "apcon = " + answer);
                }
            case "e" :
                answer = (n1 * Irrational.E);
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.E);
                    return (n1 + "e = " + answer + "\n" + n2 + "e = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "e = " + answer);
                }
            case "g" :
                answer = (n1 * Irrational.G);
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.G);
                    return (n1 + "g = " + answer + "\n" + n2 + "g = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "g = " + answer);
                }
            case "khincon" :
                answer = (n1 * Irrational.KHINCON);
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.KHINCON);
                    return (n1 + "khincon = " + answer + "\n" + n2 + "khincon = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "khincon = " + answer);
                }
            case "phi" :
                answer = (n1 * Irrational.PHI);
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.PHI);
                    return (n1 + "phi = " + answer + "\n" + n2 + "phi = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "phi = " + answer);
                }
            case "pi" :
                answer = Irrational.PI;
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.PI);
                    return (n1 + "pi = " + answer + "\n" + n2 + "pi = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "pi = " + answer);
                }
            case "pycon" :
                answer = (n1 * Irrational.PYCON);
                if(n2 != 0) {
                    answer2 = (n2 * Irrational.PYCON);
                    return (n1 + "pycon = " + answer + "\n" + n2 + "pycon = " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + "pycon = " + answer);
                }
            case "rnd", "round" :
                answer = Math.round(n1);
                if(n2 != 0) {
                    answer2 = Math.round(n2);
                    return (n1 + " rounded is " + answer + "\n" + n2 + " rounded is " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + " rounded is " + answer);
                }
            case "trunc", "truncate" :
                answer = (int) n1;
                if(n2 != 0) {
                    answer2 = (int) n2;
                    return (n1 + " truncated is " + answer + "\n" + n2 + " truncated is " + answer2);
                }
                else {
                    answer2 = 0;
                    return (n1 + " truncated is " + answer);
                }
            case "sin", "sine" :
                answer = Math.sin(n1);
                answer2 = 0;
                return ("sin(" + n1 + ") = " + answer);
            case "asin", "arcsine", "arcsin" :
                answer = Math.asin(n1);
                answer2 = 0;
                return ("asin(" + n1 + ") = " + answer);
            case "sinh" :
                answer = Math.sinh(n1);
                answer2 = 0;
                return ("sinh(" + n1 + ") = " + answer);
            case "cos", "cosine" :
                answer = Math.cos(n1);
                answer2 = 0;
                return ("cos(" + n1 + ") = " + answer);
            case "acos", "arccosine", "arccos" :
                answer = Math.acos(n1);
                answer2 = 0;
                return ("acos(" + n1 + ") = " + answer);
            case "cosh" :
                answer = Math.cosh(n1);
                answer2 = 0;
                return ("cosh(" + n1 + ") = " + answer);
            case "tan", "tangent" :
                answer = Math.tan(n1);
                answer2 = 0;
                return ("tan(" + n1 + ") = " + answer);
            case "atan", "arctangent", "arctan" :
                answer = Math.atan(n1);
                answer2 = 0;
                return ("atan(" + n1 + ") = " + answer);
            case "tanh" :
                answer = Math.tanh(n1);
                answer2 = 0;
                return ("tanh(" + n1 + ") = " + answer);
            case "ln", "natlog" :
                answer = Math.log(n1) / Math.log(Math.E);
                answer2 = 0;
                return ("ln(" + n1 + ") = " + answer);
            case "log" :
                double logn1 = Math.log(n1);
                double logn2 = Math.log(n2);
                if(n2 == 10) {
                    answer = logn1/logn2;
                    answer2 = 0;
                    return ("log(" + n1 + ") = " + answer);
                }
                else {
                    if((n2 > 0 && n1 > 0) || (n2 == n1)) {
                        if(n2 == n1) {
                            answer = 1;
                            answer2 = 0;
                            return ("log_" + n2 + "(" + n1 + ") = " + answer);
                        }
                        else {
                            answer = logn1/logn2;
                            answer2 = logn2/logn1;
                            return ("log_" + n2 + "(" + n1 + ") = " + answer + "\nlog_" + n1 + "(" + n2 + ") = " + answer2);
                        }
                    }
                    return (undefinedNegativeBase.toString());
                }
        }
        return (unknownFunction.toString());
    }

    public double getAnswer() {
        return answer;
    }

    public double getAnswer2() {
        return answer2;
    }
}