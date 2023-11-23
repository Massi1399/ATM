package test;

import code.Business_logic.Euro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

public class TestEuro {
    private Euro euro;
    
    @BeforeEach
    public void setup() {
        euro = new Euro(10);
    }
    
    @Test
    public void testGetAmount() {
        Assertions.assertEquals(10, euro.getValore());
    }
    
    @Test
    public void testAdd() {
        Euro otherEuro = new Euro(5);
        Euro result = euro.somma(otherEuro);
        Assertions.assertEquals(15, result.getValore());
    }
    
    @Test
    public void testSubtract() {
        Euro otherEuro = new Euro(3);
        Euro result = euro.sottrai(otherEuro);
        Assertions.assertEquals(7, result.getValore());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testParameterized(int value) {
        Euro otherEuro = new Euro(value);
        Euro result = euro.somma(otherEuro);
        Assertions.assertEquals(10 + value, result.getValore());
    }
}
