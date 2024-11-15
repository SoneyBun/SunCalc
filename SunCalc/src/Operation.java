import java.lang.Math;
import java.math.BigInteger;

public class Operation {
    private final double n1, n2;
    private final String fn;

    public Operation(double n1, double n2, String fn) {
        this.n1 = n1;
        this.n2 = n2;
        this.fn = fn;
    }

    private final Report unknownFunction = assignReport("Error - Unknown Function");
    private final Report undefinedDivideByZero = assignReport("Undefined - Dividing By Zero");
    private final Report undefinedFactorialOfANegative = assignReport("Undefined - Factorial Of A Negative");
    private final Report factorialOfADouble = assignReport("Error - Factorial Of A Double");

    public Report assignReport(String reason) {
        return new Report(reason);
    }

    public String toString() {
        switch (fn.toLowerCase()) {
            case "+" :
                if((n1 == 9 && n2 == 10) || (n1 == 10 && n2 == 9)) {
                    return(n1 + " + " + n2 + " = " + (n1 + n2) + "\n\n\n\n\n9 + 10 = 21");
                }
                return (n1 + " + " + n2 + " = " + (n1 + n2));
            case "-" : return (n1 + " - " + n2 + " = " + (n1 - n2));
            case "*" : return (n1 + " * " + n2 + " = " + (n1 * n2));
            case "/" :
                if(n2 != 0) {
                    return (n1 + " / " + n2 + " = " + (n1 / n2));
                }
                return ("" + undefinedDivideByZero);
            case "//" :
                if(n2 != 0) {
                    return (n1 + " // " + n2 + " = " + ((int) (n1 / n2)));
                }
                return ("" + undefinedDivideByZero);
            case ">" : return ("" + (n1 > n2));
            case ">=" : return ("" + (n1 >= n2));
            case "<" : return ("" + (n1 < n2));
            case "<=" : return ("" + (n1 <= n2));
            case "=", "==" : return("" + (n1 == n2));
            case "!=" : return ("" + (n1 != n2));
            case "max" : return ("" + Math.max(n1, n2));
            case "min" : return ("" + Math.min(n1, n2));
            case "%" : return (n1 + " % " + n2 + " = " + (n1 % n2));
            case "||" : return ("|" + n1 + "| = " + Math.abs(n1));
            case "!" :
                BigInteger factorial = BigInteger.ONE;
                BigInteger factorialTruncatedN1 = BigInteger.ONE;
                BigInteger factorialRoundedN1 = BigInteger.ONE;

                if(n1 >= 0) {
                    if(n1 == (int) n1) {
                        for(int i = 1; i <= (int) n1; i++) {
                            factorial = factorial.multiply(BigInteger.valueOf(i));
                        }
                        return (n1 + "! = " + factorial);
                    }
                    else {
                        int truncatedN1 = (int) (n1);
                        int roundedN1 = (int) (n1 + .5);

                        for(int i = 1; i <= truncatedN1; i++) {
                            factorialTruncatedN1 = factorialTruncatedN1.multiply(BigInteger.valueOf(i));
                        }

                        for(int i = 1; i <= roundedN1; i++) {
                            factorialRoundedN1 = factorialRoundedN1.multiply(BigInteger.valueOf(i));
                        }

                        if(truncatedN1 != roundedN1) {
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated is \n" + truncatedN1 + "! = " + factorialTruncatedN1 + "\nThe factorial of " + n1 + " rounded is \n" + roundedN1 + "! = " + factorialRoundedN1);
                        }
                        else {
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated/rounded is \n" + truncatedN1 + "! = " + truncatedN1);
                        }
                    }
                }
                else {
                    if(n1 == (int) n1) {
                        for(int i = 1; i <= (int) (n1 * -1); i++) {
                            factorial = factorial.multiply(BigInteger.valueOf(i));
                        }
                        return (undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive is \n" + (n1 * -1) + "! = " + factorial);
                    }

                    int positiveTruncatedN1 = (int) (n1 * -1);
                    int positiveRoundedN1 = (int) ((n1 * -1) + .5);

                    BigInteger factorialPositiveTruncatedN1 = BigInteger.ONE;
                    BigInteger factorialPositiveRoundedN1 = BigInteger.ONE;

                    for(int i = 1; i <= positiveTruncatedN1; i++) {
                        factorialPositiveTruncatedN1 = factorialPositiveTruncatedN1.multiply(BigInteger.valueOf(i));
                    }

                    for(int i = 1; i <= positiveRoundedN1; i++) {
                        factorialPositiveRoundedN1 = factorialPositiveRoundedN1.multiply(BigInteger.valueOf(i));
                    }

                    if(positiveTruncatedN1 != positiveRoundedN1) {
                        return (factorialOfADouble + "\n" + undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive and truncated is \n" + positiveTruncatedN1 + "! = " + factorialPositiveTruncatedN1 + "\nThe factorial of " + n1 + " positive and rounded is \n" + positiveRoundedN1 + "! = " + factorialPositiveRoundedN1);
                    }
                    else {
                        return (factorialOfADouble + "\n" + undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive and truncated/rounded is \n" + positiveTruncatedN1 + "! = " + factorialPositiveTruncatedN1);
                    }
                }
            case "^" : return (n1 + "^" + n2 + " = " + Math.pow(n1, n2));
            case "rt" : return (n1 + "^(1.0/" + n2 + ") = " + Math.pow(n1, (1 / n2)));
            case "pi" : return (n1 + "pi = " + (n1 * Math.PI));
            case "e" : return (n1 + "e = " + (n1 * Math.E));
            case "sin" : return ("sin(" + n1 + ") = " + Math.sin(n1));
            case "asin" : return ("asin(" + n1 + ") = " + Math.asin(n1));
            case "sinh" : return ("sinh(" + n1 + ") = " + Math.sinh(n1));
            case "cos" : return ("cos(" + n1 + ") = " + Math.cos(n1));
            case "acos" : return ("acos(" + n1 + ") = " + Math.acos(n1));
            case "cosh" : return ("cosh(" + n1 + ") = " + Math.cosh(n1));
            case "tan" : return ("tan(" + n1 + ") = " + Math.tan(n1));
            case "atan" : return ("atan(" + n1 + ") = " + Math.atan(n1));
            case "tanh" : return ("tanh(" + n1 + ") = " + Math.tanh(n1));
            case "ln" : return ("ln(" + n1 + ") = " + Math.log(n1));
            case "log10" : return("log10(" + n1 + ") = " + Math.log10(n1));
        }
        return ("" + unknownFunction);
    }
}
