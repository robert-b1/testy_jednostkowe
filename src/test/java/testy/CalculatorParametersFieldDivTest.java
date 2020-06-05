package testy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnit4.class)
public class CalculatorParametersFieldDivTest {
    //niestety coś jest tu nie tak, trzeba poprawić żeby działało
    @Parameterized.Parameter(value = 1)
    public int numberA;

    @Parameterized.Parameter(value = 2)
    public int numberB;

    @Parameterized.Parameter(value = 3)
    public String expectedResult;

    @Parameterized.Parameters(name = "Test {index}: {1}/{2}={3}")
    public static Collection<Object> data() {
        return Arrays.asList(
                new Object[][]{{4, 2, "2"}},
                new Object[][]{{6, 3, "2"}},
                new Object[][]{{10, 2, "5"}});
    }

    @Test
    public void shouldDivSuccessedExcecuteTest() {
        //Given
        Calculator calculator = new CalculatorImpl() {
            @Override
            public void pressNumber(Object number) {
            }
        };
        //When
        calculator.div(numberA, numberB);
        //Then
        String resultDisplay = calculator.display();
        Assertions.assertEquals(expectedResult, resultDisplay);
    }
}