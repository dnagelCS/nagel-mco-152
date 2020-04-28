package nagel.cashier;

import java.lang.Math;

public class Cashier {
    Cash cashRegister = new Cash();

    public Cash pay(double price, Cash customerPay) throws NotEnoughChangeException {
        Cash change = new Cash();

        double moneyOwed = 0;
        if (customerPay.totalCash() > price) {
            moneyOwed = customerPay.totalCash() - price;
            moneyOwed = Math.round(moneyOwed * 100.0) / 100.0;
        }
        //exact change
        if(moneyOwed == 0) {
            addPayToRegister(customerPay);
        }
        //broke cashier
        if (cashRegister.totalCash() == 0) {
            throw new NotEnoughChangeException();
        }
        else {
            try {
                change = calculateChange(change, moneyOwed, cashRegister);
                moneyOwed = updateMoneyOwed(change, moneyOwed);
                if (moneyOwed != 0) {
                    throw new NotEnoughChangeException();
                }
                addPayToRegister(customerPay);
                subChangeFromRegister(change);
            }
            catch (NotEnoughChangeException exc) {
                return cashRegister;
            }
            return change;
        }
    }

    public Cash calculateChange(Cash change, double moneyOwed, Cash cashRegister){
        while (moneyOwed >= cashRegister.TWENTIES && cashRegister.getTwentiesAmt() > 1) {
            change.addTwenties(1);
            moneyOwed -= change.TWENTIES;
        }
        while (moneyOwed >= cashRegister.TENS && cashRegister.getTensAmt() > 1) {
            change.addTens(1);
            moneyOwed -= change.TENS;
        }
        while (moneyOwed >= cashRegister.FIVES && cashRegister.getFivesAmt() > 1) {
            change.addFives(1);
            moneyOwed -= change.FIVES;
        }
        while (moneyOwed >= cashRegister.ONES && cashRegister.getOnesAmt() > 1) {
            change.addOnes(1);
            moneyOwed -= change.ONES;
        }
        while (moneyOwed >= cashRegister.QUARTERS && cashRegister.getQuarterAmt() > 1) {
            change.addQuarters(1);
            moneyOwed -= change.QUARTERS;
        }
        while (moneyOwed >= cashRegister.DIMES && cashRegister.getDimeAmt() > 1) {
            change.addDimes(1);
            moneyOwed -= change.DIMES;
        }
        while (moneyOwed >= cashRegister.NICKELS && cashRegister.getNickelAmt() > 1) {
            change.addNickels(1);
            moneyOwed -= change.NICKELS;
        }
        while (moneyOwed >= cashRegister.PENNIES && cashRegister.getPennyAmt() > 1) {
            change.addPennies(1);
            moneyOwed -= change.PENNIES;
        }
        return change;
    }

    private void addPayToRegister(Cash customerPay) {
        cashRegister.addPennies(customerPay.getPennyAmt());
        cashRegister.addNickels(customerPay.getNickelAmt());
        cashRegister.addDimes(customerPay.getDimeAmt());
        cashRegister.addQuarters(customerPay.getQuarterAmt());
        cashRegister.addOnes(customerPay.getOnesAmt());
        cashRegister.addFives(customerPay.getFivesAmt());
        cashRegister.addTens(customerPay.getTensAmt());
        cashRegister.addTwenties(customerPay.getTwentiesAmt());
    }

    private void subChangeFromRegister(Cash change) {
        cashRegister.subPennies(change.getPennyAmt());
        cashRegister.subNickels(change.getNickelAmt());
        cashRegister.subDimes(change.getDimeAmt());
        cashRegister.subQuarters(change.getQuarterAmt());
        cashRegister.subOnes(change.getOnesAmt());
        cashRegister.subFives(change.getFivesAmt());
        cashRegister.subTens(change.getTensAmt());
        cashRegister.subTwenties(change.getTwentiesAmt());
    }

    private double updateMoneyOwed(Cash cash, double moneyOwed) {
        moneyOwed -= cash.totalCash();
        return moneyOwed;
    }
}
