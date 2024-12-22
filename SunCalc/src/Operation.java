import java.lang.Math;
import java.math.BigInteger;
@SuppressWarnings("all")

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
                answer2 = 0;
                return (n1 + " % " + n2 + " = " + answer);
            case "||" :
                answer = Math.abs(n1);
                answer2 = 0;
                return ("|" + n1 + "| = " + answer);
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

                        if(truncatedN1 != roundedN1) {
                            answer = factorialTruncatedN1.doubleValue();
                            answer2 = factorialRoundedN1.doubleValue();
                            return (factorialOfADouble + "\nThe factorial of " + n1 + " truncated is \n" + truncatedN1 + "! = " + answer + "\nThe factorial of " + n1 + " rounded is \n" + roundedN1 + "! = " + answer2);
                        }
                        else {
                            answer = factorialTruncatedN1.doubleValue();
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

                    if(positiveTruncatedN1 != positiveRoundedN1) {
                        answer = factorialPositiveTruncatedN1.doubleValue();
                        answer2 = factorialPositiveRoundedN1.doubleValue();
                        return (factorialOfADouble + "\n" + undefinedFactorialOfANegative + "\nThe factorial of " + n1 + " positive and truncated is \n" + positiveTruncatedN1 + "! = " + answer + "\nThe factorial of " + n1 + " positive and rounded is \n" + positiveRoundedN1 + "! = " + answer2);
                    }
                    else {
                        answer = factorialPositiveTruncatedN1.doubleValue();
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
            case "pi" :
                answer = (n1 * Math.PI);
                answer2 = 0;
                return (n1 + "pi = " + answer);
            case "e" :
                answer = (n1 * Math.E);
                answer2 = 0;
                return (n1 + "e = " + answer);
            case "phi" :
                answer = (n1 * ((1 + Math.sqrt(5)) / 2));
                answer2 = 0;
                return (n1 + "phi = " + answer);
            case "rnd", "round" :
                answer = Math.round(n1);
                answer2 = 0;
                return (n1 + " rounded is " + answer);
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
            case "ln", "log_e" :
                answer = Math.log(n1) / Math.log(Math.E);
                answer2 = 0;
                return ("ln(" + n1 + ") = " + answer);
            case "log" :
                if(n2 == 10) {
                    answer = Math.log(n1) / Math.log(n2);
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
                            answer = Math.log(n1) / Math.log(n2);
                            answer2 = Math.log(n2) / Math.log(n1);
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
