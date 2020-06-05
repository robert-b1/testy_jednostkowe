package testy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorParametrizedJUnitParamsMethodTest {
    //niestety coś jest tu nie tak, trzeba poprawić żeby działało
    private Calculator calc;

    @Before
    public void setUp() {
        //given
        calc = new CalculatorImpl();
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void testAdd(int numberA, int numberB, String expected) {

        //when
        calc.add(numberA, numberB);

        //then
        String message = String.format("Error %d + %d != %s becouse is equal %d",
                numberA, numberB, calc.display(), numberA + numberB);
        assertEquals(message, expected, calc.display());
    }

    private Object[] parametersToTestAdd() {// użyte do testów parametryzacyjnych
        return new Object[]{
                new Object[]{1, 2, 3},
                new Object[]{2, 2, 4},
                new Object[]{5, 2, 7}
        };
    }
}