package testy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class
CalculatorParametersConstructorAddTest {
    //niestety coś jest tu nie tak, trzeba poprawić żeby działało
    int numberA;
    int numberB;
    String expectedResult;

    public CalculatorParametersConstructorAddTest(int numberA, int numberB, String expectedResult) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Test {index}: {0}+{1}+{2}")
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{{1, 2, "3"}, {2, 3, "5"}, {7, 3, "10"}});
    }

    @Test
    public void shouldAddSuccessedExcecuteTest() {
        //Given
        Calculator calculator = new CalculatorImpl();
        //When
        calculator.add(numberA, numberB);
        //Then
        String resultDisplay = calculator.display();
        assertEquals(expectedResult, resultDisplay);
    }
}
