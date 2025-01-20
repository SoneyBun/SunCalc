@SuppressWarnings({"UnusedAssignment", "CommentedOutCode"})

public class Storing {
    private final String storeTerm;
    private final double answer, answer2;
    private final int nSpace;

    private final String newStoreTerm;

    public Storing(String storeTerm, double answer, double answer2) {
        this.storeTerm = storeTerm;
        this.answer = answer;
        this.answer2 = answer2;
        this.newStoreTerm = storeTerm.substring(storeTerm.indexOf(' ') + 1);
        int preNSpace = 0;
        for(int i = 0; i < storeTerm.length() - 1; i++) {
            if(storeTerm.charAt(i) == ' ') {
                preNSpace++;
            }
        }

        this.nSpace = preNSpace;
    }

    public double getNum1() {
        double n1;
        switch (storeTerm.substring(0, storeTerm.indexOf(' ')).toLowerCase()) {
            case "apcon" : n1 = Irrational.APCON;
            case "e" : n1 = Irrational.E;
            case "g" : n1 = Irrational.G;
            case "khincon" : n1 = Irrational.KHINCON;
            case "phi" : n1 = Irrational.PHI;
            case "pi" : n1 = Irrational.PI;
            case "pycon" : n1 = Irrational.PYCON;
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

    public double getNum2() {
        double n2;
        if(nSpace == 2) {
            switch (newStoreTerm.substring(0, newStoreTerm.indexOf(' ')).toLowerCase()) {
                case "apcon" : n2 = Irrational.APCON;
                case "e" : n2 = Irrational.E;
                case "g" : n2 = Irrational.G;
                case "khincon" : n2 = Irrational.KHINCON;
                case "phi" : n2 = Irrational.PHI;
                case "pi" : n2 = Irrational.PI;
                case "pycon" : n2 = Irrational.PYCON;
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

    public String getFunction() {
        String fn;
        if(nSpace == 2) {
            fn = storeTerm.substring(newStoreTerm.indexOf(' ') + storeTerm.indexOf(' ') + 2);
        }
        else {
            fn = storeTerm.substring(storeTerm.indexOf(' ') + 1);
        }
        return fn.toLowerCase();
    }

    /*
    public void setNum1(double newN1) {
        this.n1 = newN1;
    }

    public void setNum2(double newN2) {
        this.n2 = newN2;
    }

    public int getNSpace() {
        return nSpace;
    }

    public int getSpace1() {
        int space1;
        space1 = storeTerm.indexOf(' ');
        return space1;
    }

    public int getSpace2() {
        int space2;
        space2 = newStoreTerm.indexOf(' ') + storeTerm.indexOf(' ') + 1;
        return space2;
    }
     */
}
