package testy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorParametrizedJUnitParamsTest {
    //niestety coś jest tu nie tak, trzeba poprawić żeby działało
    @Test
    @Parameters({"1, 1, 2", "2, 2, 4", "1, 9, 10", "2, 3, 5", "2, 9, 11"})
    public void testAdd(int numberA, int numberB, String expected) {

        //given
        Calculator calc = new CalculatorImpl();

        //when
        calc.add(numberA, numberB);

        //then
        assertEquals(expected, calc.display());
    }

    @Test
    @Parameters({"1, 1, 0", "3, 2, 1", "10, 9, 1", "6, 2, 4", "10, 5, 5"})
    public void testSub(int numberA, int numberB, String expected) {

        //given
        Calculator calc = new CalculatorImpl();

        //when
        calc.sub(numberA, numberB);

        //then
        assertEquals(expected, calc.display());
    }
}

