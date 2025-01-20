import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irrational {
    public static final double APCON = approxApCon().setScale(15, RoundingMode.HALF_UP).doubleValue();
    public static final double E = Math.E;
    public static final double G = approxG();
    public static final double KHINCON = approxKhinCon();
    public static final double PHI = ((1 + Math.sqrt(5)) / 2);
    public static final double PI = Math.PI;
    public static final double PYCON = Math.sqrt(2);

    private static BigDecimal approxApCon() {
        BigDecimal sum = BigDecimal.ZERO;

        for (int n = 1; n <= 1000000; n++) {
            BigDecimal term = BigDecimal.ONE.divide(BigDecimal.valueOf(n).pow(3), 100, RoundingMode.HALF_UP);
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
