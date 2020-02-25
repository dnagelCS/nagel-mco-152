package nagel.cashier;

import java.lang.Math;

public class Cashier {
    Cash cashRegister = new Cash();

    public Cash pay(double price, Cash customerPay) throws NotEnoughChangeException {
        final double ZERO = 0.00;

        //update register with customer payment
        updateRegister(customerPay);

        double totalCash = cashRegister.totalCash();
        
        Cash change = new Cash();
        double moneyOwed = 0;

        if (customerPay.totalCash() > price) {
            moneyOwed = customerPay.totalCash() - price;
            moneyOwed = Math.round(moneyOwed * 100.0) / 100.0;
        }

        if (moneyOwed != ZERO) {
            while (moneyOwed >= cashRegister.TWENTIES && cashRegister.getTwentiesAmt() > 1) {
                change.addTwenties(1);
                moneyOwed -= change.TWENTIES;
                cashRegister.addTwenties(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.TENS && cashRegister.getTensAmt() > 1) {
                change.addTens(1);
                moneyOwed -= change.TENS;
                cashRegister.addTens(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.FIVES && cashRegister.getFivesAmt() > 1) {
                change.addFives(1);
                moneyOwed -= change.FIVES;
                cashRegister.addFives(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.ONES && cashRegister.getOnesAmt() > 1) {
                change.addOnes(1);
                moneyOwed -= change.ONES;
                cashRegister.addOnes(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.QUARTERS && cashRegister.getQuarterAmt() > 1) {
                change.addQuarters(1);
                moneyOwed -= change.QUARTERS;
                cashRegister.addQuarters(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.DIMES && cashRegister.getDimeAmt() > 1) {
                change.addDimes(1);
                moneyOwed -= change.DIMES;
                cashRegister.addDimes(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.NICKELS && cashRegister.getNickelAmt() > 1) {
                change.addNickels(1);
                moneyOwed -= change.NICKELS;
                cashRegister.addNickels(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
            while (moneyOwed >= cashRegister.PENNIES && cashRegister.getPennyAmt() > 1) {
                change.addPennies(1);
                moneyOwed -= change.PENNIES;
                cashRegister.addPennies(-1);
                if (moneyOwed == ZERO) {
                    break;
                }
            }
        }
        return change;
    }
        private void updateRegister(Cash customerPay) {
            cashRegister.addPennies(customerPay.getPennyAmt());
            cashRegister.addNickels(customerPay.getNickelAmt());
            cashRegister.addDimes(customerPay.getDimeAmt());
            cashRegister.addQuarters(customerPay.getQuarterAmt());
            cashRegister.addOnes(customerPay.getOnesAmt());
            cashRegister.addFives(customerPay.getFivesAmt());
            cashRegister.addTens(customerPay.getTensAmt());
            cashRegister.addTwenties(customerPay.getTwentiesAmt());
        }
}
