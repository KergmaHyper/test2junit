package test2;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class CalcTest {

    @Test
    public void testAdd() {
        assertEquals(5, Calc.add(2, 3));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(5, Calc.dvd(25, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBeZero() {
        assertEquals(0, Calc.dvd(5, 0));
    }
}
