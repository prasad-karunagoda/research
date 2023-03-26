package prasad.research.maven.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Assertions.assertEquals(8, new Calculator().add(3, 5));
    }
}
