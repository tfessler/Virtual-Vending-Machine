package com.techelevator.view;

import com.techelevator.Purchase;
import com.techelevator.VendingMachine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class PurchaseTest {

    private Purchase purchaseTest;

    @Before

    public void setup() {
        purchaseTest = new Purchase();
    }

    @Test
    public void money_inserted_in_balance_sets() {
        double balanceExpected = 2.00;
        purchaseTest.setBalance(2.00);
        Assert.assertEquals(balanceExpected, purchaseTest.getBalance(), 0);



    }
    @Test
    public void balance_is_set_to_zero_by_default() {
        double balanceExpected = 0;
        Assert.assertEquals(balanceExpected, purchaseTest.getBalance(), 0);

    }
    @Test
    public void return_two_dollars_as_coins() {
        HashMap<String, Integer> coinCountTest = new HashMap<String, Integer>();
        int quarters = 8;
        int dimes = 0;
        int nickels = 0;
        coinCountTest.put("quarters", quarters);
        coinCountTest.put("dimes", dimes);
        coinCountTest.put("nickels", nickels);
        purchaseTest.setBalance(2.00);
        Assert.assertEquals(coinCountTest, purchaseTest.changeReturned(purchaseTest.getBalance()));
    }

    @Test
    public void return_one_dollars_as_coins() {
        HashMap<String, Integer> coinCountTest = new HashMap<String, Integer>();
        int quarters = 4;
        int dimes = 0;
        int nickels = 0;
        coinCountTest.put("quarters", quarters);
        coinCountTest.put("dimes", dimes);
        coinCountTest.put("nickels", nickels);
        purchaseTest.setBalance(1.00);
        Assert.assertEquals(coinCountTest, purchaseTest.changeReturned(purchaseTest.getBalance()));
    }

    @Test
    public void return_forty_cents_as_coins() {
        HashMap<String, Integer> coinCountTest = new HashMap<String, Integer>();
        int quarters = 1;
        int dimes = 1;
        int nickels = 1;
        coinCountTest.put("quarters", quarters);
        coinCountTest.put("dimes", dimes);
        coinCountTest.put("nickels", nickels);
        purchaseTest.setBalance(0.40);
        Assert.assertEquals(coinCountTest, purchaseTest.changeReturned(purchaseTest.getBalance()));
    }


}
