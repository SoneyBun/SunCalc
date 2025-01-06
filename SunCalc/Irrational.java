import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
@SuppressWarnings("all")

public class Irrational {
    public static final double apcon = approxApCon().setScale(15, RoundingMode.HALF_UP).doubleValue();
    public static final double e = Math.E;
    public static final double g = approxG();
    public static final double khincon = approxKhinCon();
    public static final double phi = ((1 + Math.sqrt(5)) / 2);
    public static final double pi = Math.PI;
    public static final double pycon = Math.sqrt(2);

    private static BigDecimal approxApCon() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int n = 1; n <= 1000000; n++) {
            BigDecimal term = BigDecimal.ONE.divide(BigDecimal.valueOf(n).pow(3), 100, RoundingMode.HALF_UP);  // Using high precision
            sum = sum.add(term);
        }
        return sum;
    }

    private static double approxG() {
        double sum = 0.0;
        for (int n = 0; n < 1000000; n++) {
            sum += Math.pow(-1, n) / Math.pow(2 * n + 1, 2);
        }
        return sum;
    }

    private static double approxKhinCon() {
        double product = 1;
        for (int n = 1; n <= 1000000; n++) {
            product *= Math.pow(1 + 1.0 / (n * n), 1.0 / (n * n));
        }
        return product;
    }
}
