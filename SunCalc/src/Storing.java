import java.lang.Math;
@SuppressWarnings("all")

public class Storing {
    private final String storeTerm;
    private final double answer, answer2;

    private double n1, n2;
    private String fn = "";

    private int preNSpace, space1, space2;
    private final int nSpace;

    private final String newStoreTerm;

    public Storing(String storeTerm, double answer, double answer2) {
        this.storeTerm = storeTerm;
        this.answer = answer;
        this.answer2 = answer2;
        this.newStoreTerm = storeTerm.substring(storeTerm.indexOf(' ') + 1);

        for(int i = 0; i < storeTerm.length() - 1; i++) {
            if(storeTerm.charAt(i) == ' ') {
                preNSpace++;
            }
        }

        this.nSpace = preNSpace;
    }

    public int getNSpace() {
        return nSpace;
    }

    public int getSpace1() {
        space1 = storeTerm.indexOf(' ');
        return space1;
    }

    public int getSpace2() {
        space2 = newStoreTerm.indexOf(' ') + storeTerm.indexOf(' ') + 1;
        return space2;
    }

    public double getNum1() {
        switch (storeTerm.substring(0, storeTerm.indexOf(' ')).toLowerCase()) {
            case "pi" : n1 = Math.PI;
            case "e" : n1 = Math.E;
            case "phi" : n1 = ((1 + Math.sqrt(5)) / 2);
            case "pycon" : n1 = Math.sqrt(2);
            case "ans", "answer" : n1 = answer;
            case "ans2", "answer2" : n1 = answer2;
            default :
                try {
                    n1 = Double.parseDouble(storeTerm.substring(0, storeTerm.indexOf(' ')));
                } catch (NumberFormatException e) {
                    return 0;
                }
        }
        return n1;
    }

    public void setNum1(double newN1) {
        this.n1 = newN1;
    }

    public double getNum2() {
        if(nSpace == 2) {
            switch (newStoreTerm.substring(0, newStoreTerm.indexOf(' ')).toLowerCase()) {
                case "pi" : n2 = Math.PI;
                case "e" : n2 = Math.E;
                case "phi" : n2 = ((1 + Math.sqrt(5)) / 2);
                case "pycon" : n2 = Math.sqrt(2);
                case "ans", "answer" : n2 = answer;
                case "ans2", "answer2" : n2 = answer2;
                default :
                    try {
                        n2 = Double.parseDouble(newStoreTerm.substring(0, newStoreTerm.indexOf(' ')));
                    } catch (NumberFormatException e) {
                        return 0;
                    }
            }
        }
        else {
            n2 = 0;
        }
        return n2;
    }

    public void setNum2(double newN2) {
        this.n2 = newN2;
    }

    public String getFunction() {
        if(nSpace == 2) {
            fn = storeTerm.substring(newStoreTerm.indexOf(' ') + storeTerm.indexOf(' ') + 2);
        }
        else {
            fn = storeTerm.substring(storeTerm.indexOf(' ') + 1);
        }
        return fn.toLowerCase();
    }
}
