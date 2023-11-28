package test;
import code.Database.BankDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBankDatabase {
    
    //Dati account Test userAccontNumber = 12345, userPIN = 54321

    private BankDatabase bankDatabase;
    
    @BeforeEach
    public void setUp() {
        bankDatabase = new BankDatabase();
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
        bankDatabase.credit(12345, 100);
        Assertions.assertEquals(bankDatabase.getTotalBalance(12345).getValore(), 120100);
    }

    @Test
    public void debit() {
        bankDatabase.debit(12345, 100);
        Assertions.assertEquals(bankDatabase.getTotalBalance(12345).getValore(), 110000);
    }

}