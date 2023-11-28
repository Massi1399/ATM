package test;

import code.Database.BankDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class TestAccount {

    private Account account;
    private Euro euro;

     @BeforeEach
    public void setup() {
        // Create a new Account object for each test
        account = new Account(123, 321, new Euro (500), new Euro(800));
    }

    @Test
    public void testGetAccountNumber() {
        // Test the getAccountNumber() method
        Assertions.assertEquals(account.getAccountNumber(), 123);
    }

    @Test
    public void testvalidatePIN_true() {
        // Test the getPIN() method
        Assertions.assertTrue(account.validatePIN(321));
    }

    @Test
    public void testvalidatePIN_false() {
        // Test the getPIN() method
        Assertions.assertFalse(account.validatePIN(331));
    }
    
    @Test   
    public void testGetAvailableBalance() {
        // Test the getAvailableBalance() method
        Assertions.assertEquals(account.getAvailableBalance().getValore(), 50000);
    }

    @Test
    public void testGetTotalBalance() {
        // Test the getTotalBalance() method
        Assertions.assertEquals(account.getTotalBalance().getValore(), 80000);
    }

    @Test
    public void testCredit() {
        // Test the credit() method
        euro = new Euro(100);
        account.credit(euro);
        Assertions.assertEquals(account.getTotalBalance().getValore(), 90000);
    }

    @Test
    public void testDebit() {
        // Test the debit() method
        euro = new Euro(100);
        account.debit(euro);
        Assertions.assertEquals(account.getTotalBalance().getValore(), 70000);
    }
    
}
