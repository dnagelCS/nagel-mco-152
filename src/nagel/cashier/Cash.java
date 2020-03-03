package nagel.cashier;

public class Cash {
    public static final double PENNIES = 0.01;
    public static final double NICKELS = 0.05;
    public static final double DIMES = 0.10;
    public static final double QUARTERS = 0.25;
    public static final double ONES = 1.00;
    public static final double FIVES = 5.00;
    public static final double TENS = 10.00;
    public static final double TWENTIES = 20.00;

    private int pennyAmt, nickelAmt, dimeAmt, quarterAmt, onesAmt, fivesAmt, tensAmt, twentiesAmt;

    public Cash() {}

    public Cash(int pennyAmt, int nickelAmt, int dimeAmt, int quarterAmt, int ones, int fives, int tens, int twenties) {
        this.pennyAmt = pennyAmt;
        this.nickelAmt = nickelAmt;
        this.dimeAmt = dimeAmt;
        this.quarterAmt = quarterAmt;
        this.onesAmt = ones;
        this.fivesAmt = fives;
        this.tensAmt = tens;
        this.twentiesAmt = twenties;
    }

    public double totalCash() {
        return (pennyAmt *PENNIES) + (nickelAmt *NICKELS) + (dimeAmt *DIMES) + (quarterAmt *QUARTERS) +
                (onesAmt *ONES) + (fivesAmt *FIVES) + (tensAmt *TENS) + (twentiesAmt *TWENTIES);
    }

    public void setPennyAmt(int pennyAmt) {
        this.pennyAmt = pennyAmt;
    }

    public int getPennyAmt() {
        return pennyAmt;
    }

    public void addPennies(int pennyAmt) {
        this.pennyAmt += pennyAmt;
    }

    public void subPennies(int pennyAmt) {
        this.pennyAmt -= pennyAmt;
    }

    public void setNickelAmt(int nickelAmt) {

        this.nickelAmt = nickelAmt;
    }

    public int getNickelAmt() {
        return nickelAmt;
    }

    public void addNickels(int nickelAmt) {
        this.nickelAmt += nickelAmt;
    }

    public void subNickels(int nickelAmt) {
        this.nickelAmt -= nickelAmt;
    }

    public void setDimeAmt(int dimeAmt) {
        this.dimeAmt = dimeAmt;
    }

    public int getDimeAmt() {
        return dimeAmt;
    }

    public void addDimes(int dimeAmt) {
        this.dimeAmt += dimeAmt;
    }

    public void subDimes(int dimeAmt) {
        this.dimeAmt -= dimeAmt;
    }

    public void setQuarterAmt(int quarterAmt) {

        this.quarterAmt = quarterAmt;
    }

    public int getQuarterAmt() {
        return quarterAmt;
    }

    public void addQuarters(int quarterAmt) {
        this.quarterAmt += quarterAmt;
    }

    public void subQuarters(int quarterAmt) {
        this.quarterAmt -= quarterAmt;
    }

    public void setOnesAmt(int onesAmt) {
        this.onesAmt = onesAmt;
    }

    public int getOnesAmt() {
        return onesAmt;
    }

    public void addOnes(int onesAmt) {
        this.onesAmt += onesAmt;
    }

    public void subOnes(int onesAmt) {
        this.onesAmt -= onesAmt;
    }

    public void setFivesAmt(int fivesAmt) {

        this.fivesAmt = fivesAmt;
    }

    public int getFivesAmt() {
        return fivesAmt;
    }

    public void addFives(int fivesAmt) {
        this.fivesAmt += fivesAmt;
    }

    public void subFives(int fivesAmt) {
        this.fivesAmt -= fivesAmt;
    }

    public void setTensAmt(int tensAmt) {
        this.tensAmt = tensAmt;
    }

    public int getTensAmt() {
        return tensAmt;
    }

    public void addTens(int tensAmt) {
        this.tensAmt += tensAmt;
    }

    public void subTens(int tensAmt) {
        this.tensAmt -= tensAmt;
    }

    public void setTwentiesAmt(int twentiesAmt) {
        this.twentiesAmt = twentiesAmt;
    }

    public int getTwentiesAmt() {
        return twentiesAmt;
    }

    public void addTwenties(int twentiesAmt) {
        this.twentiesAmt += twentiesAmt;
    }

    public void subTwenties(int twentiesAmt) {
        this.twentiesAmt -= twentiesAmt;
    }
}
