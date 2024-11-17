import java.lang.Math;
import java.math.BigInteger;
@SuppressWarnings("SpellCheckingInspection")

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
            case "+", "add", "plus" : return (n1 + " + " + n2 + " = " + (n1 + n2));
            case "++", "increment" : return (n1 + "++ = " + (n1 + 1));
            case "-", "subtract", "minus" : return (n1 + " - " + n2 + " = " + (n1 - n2));
            case "--", "decrement" : return (n1 + "-- = " + (n1 - 1));
            case "*", "multiply", "times" : return (n1 + " * " + n2 + " = " + (n1 * n2));
            case "/", "divide" :
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
            case "=", "==" : return ("" + (n1 == n2));
            case "!=" : return ("" + (n1 != n2));
            case "max", "maximum" : return ("" + Math.max(n1, n2));
            case "min", "minimum" : return ("" + Math.min(n1, n2));
            case "%", "modulus", "mod" : return (n1 + " % " + n2 + " = " + (n1 % n2));
            case "||" : return ("|" + n1 + "| = " + Math.abs(n1));
            case "!", "factorial" :
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
                        int roundedN1 = (int) Math.round(n1);

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
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated/rounded is \n" + truncatedN1 + "! = " + factorialTruncatedN1);
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
                    int positiveRoundedN1 = (int) Math.round(n1 * -1);

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
            case "^", "exponent", "power", "exp", "pow" : return (n1 + "^" + n2 + " = " + Math.pow(n1, n2));
            case "rt", "root" : return (n1 + "^(1.0/" + n2 + ") = " + Math.pow(n1, (1 / n2)));
            case "pi" : return (n1 + "pi = " + (n1 * Math.PI));
            case "e" : return (n1 + "e = " + (n1 * Math.E));
            case "phi" : return (n1 + "phi = " + (n1 * ((1 + Math.sqrt(5)) / 2)));
            case "rnd", "round" : return (n1 + " rounded is " + Math.round(n1));
            case "sin", "sine" : return ("sin(" + n1 + ") = " + Math.sin(n1));
            case "asin", "arcsine", "arcsin" : return ("asin(" + n1 + ") = " + Math.asin(n1));
            case "sinh" : return ("sinh(" + n1 + ") = " + Math.sinh(n1));
            case "cos", "cosine" : return ("cos(" + n1 + ") = " + Math.cos(n1));
            case "acos", "arccosine", "arccos" : return ("acos(" + n1 + ") = " + Math.acos(n1));
            case "cosh" : return ("cosh(" + n1 + ") = " + Math.cosh(n1));
            case "tan", "tangent" : return ("tan(" + n1 + ") = " + Math.tan(n1));
            case "atan", "arctangent", "arctan" : return ("atan(" + n1 + ") = " + Math.atan(n1));
            case "tanh" : return ("tanh(" + n1 + ") = " + Math.tanh(n1));
            case "ln" : return ("ln(" + n1 + ") = " + Math.log(n1));
            case "log10" : return ("log10(" + n1 + ") = " + Math.log10(n1));
        }
        return ("" + unknownFunction);
    }
}
