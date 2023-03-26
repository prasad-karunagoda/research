package prasad.research.maven.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondIT {

    @Test
    public void testAdd() {
        Assertions.assertEquals(37, new Calculator().add(14, 23));
    }
}
