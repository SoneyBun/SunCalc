import java.lang.Math;
@SuppressWarnings({"FieldCanBeLocal", "unused"})

public class Storing {
    private final String storeTerm;

    private double n1, n2;
    private String fn = "";

    private int preNSpace, space1, space2;
    private final int nSpace;

    private final String newStoreTerm;

    public Storing(String storeTerm) {
        this.storeTerm = storeTerm;
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
        if(storeTerm.substring(0, storeTerm.indexOf(' ')).equalsIgnoreCase("pi")) {
            n1 = Math.PI;
        }
        else if(storeTerm.substring(0, storeTerm.indexOf(' ')).equalsIgnoreCase("e")) {
            n1 = Math.E;
        }
        else {
            n1 = Double.parseDouble(storeTerm.substring(0, storeTerm.indexOf(' ')));
        }
        return n1;
    }

    public double getNum2() {
        if(nSpace == 2) {
            if(newStoreTerm.substring(0, newStoreTerm.indexOf(' ')).equalsIgnoreCase("pi")) {
                n2 = Math.PI;
            }
            else if(newStoreTerm.substring(0, newStoreTerm.indexOf(' ')).equalsIgnoreCase("e")) {
                n2 = Math.E;
            }
            else {
                n2 = Double.parseDouble(newStoreTerm.substring(0, newStoreTerm.indexOf(' ')));
            }
            return n2;
        }
        return 0;
    }

    public String getFunction() {
        if(nSpace == 2) {
            fn = storeTerm.substring(newStoreTerm.indexOf(' ') + storeTerm.indexOf(' ') + 2);
        }
        else {
            fn = storeTerm.substring(storeTerm.indexOf(' ') + 1);
        }
        return fn;
    }
}
