package Cashier;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CashierTest {

    @Test
    public void pay() {
        //given
        Cashier cashier = new Cashier();
        cashier.cashRegister.setPennyAmt(100);
        cashier.cashRegister.setQuarterAmt(100);

        Cash customerPay = new Cash();
        customerPay.setOnesAmt(3);

        Cash change = new Cash();

        //when
        change = cashier.pay(2.49, customerPay);

        //then
        assertEquals(1, change.getPennyAmt());
        assertEquals(2, change.getQuarterAmt());

        assertEquals(99, cashier.cashRegister.getPennyAmt());
        assertEquals(98, cashier.cashRegister.getQuarterAmt());
        assertEquals(3, cashier.cashRegister.getOnesAmt());
    }
}
