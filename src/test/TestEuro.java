package test;

import code.Business_logic.Euro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEuro {
    private Euro euro;
    
    @BeforeEach
    public void setup() {
        euro = new Euro(10);
    }
    
    @Test
    public void testGetValore() {
        Assertions.assertEquals(1000, euro.getValore());
    }
    
    @Test
    public void testSomma() {
        Euro otherEuro = new Euro(5);
        Euro result = euro.somma(otherEuro);
        Assertions.assertEquals(1500, result.getValore());
    }
    
    @Test
    public void testSottrai() {
        Euro otherEuro = new Euro(3);
        Euro result = euro.sottrai(otherEuro);
        Assertions.assertEquals(700, result.getValore());
    }

    
    @Test
    public void testUgualeA() {
        Euro otherEuro = new Euro(10);
        Assertions.assertTrue(euro.ugualeA(otherEuro));
    }

    @Test

    public void testMinoreDi() {
        Euro otherEuro = new Euro(20);
        Assertions.assertTrue(euro.minoreDi(otherEuro));
    }

    @Test
    public void testStampa() {
        Assertions.assertEquals("10.0 euro", euro.stampa());
    }
}
