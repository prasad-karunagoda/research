package prasad.research.maven.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorIT {

    @Test
    public void testAdd() {
        Assertions.assertEquals(5, new Calculator().add(2, 3));
    }
}
