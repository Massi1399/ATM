package test;
import code.Database.BankDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Business_logic.Euro;

public class TestBankDatabase {
    
    //Dati account Test userAccontNumber = 12345, userPIN = 54321

    private BankDatabase bankDatabase;
    private Euro euro;
    @BeforeEach
    public void setUp() {
        bankDatabase = new BankDatabase();
        euro = new Euro(1000, 0);
    }

    @Test
    public void testAuthenticateUserValid() {
        Assertions.assertTrue(bankDatabase.authenticateUser(12345, 54321));
    }

    @Test
    public void testAuthenticateUserInvalid() {
        Assertions.assertFalse(bankDatabase.authenticateUser(12345, 54322));
    }

    @Test
    public void testGetAvailableBalance() {
        Assertions.assertEquals(bankDatabase.getAvailableBalance(12345).getValore(), 100000);
    }

    @Test
    public void testGetTotalBalance() {
        Assertions.assertEquals(bankDatabase.getTotalBalance(12345).getValore(), 120000);
    }

    @Test
    public void credit() {
        bankDatabase.credit(12345, euro);
        Assertions.assertEquals(bankDatabase.getTotalBalance(12345).getValore(), 220000);
    }

    @Test
    public void debit() {
        bankDatabase.debit(12345, euro);
        Assertions.assertEquals(bankDatabase.getTotalBalance(12345).getValore(), 20000);
    }

}