package myproject;


import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;


import java.util.Collection;



@RunWith(JUnit4.class)
public class CalculatorParametersFieldsSubTest {
    @Parameterized.Parameter(value = 0)
    public int numberA;

    @Parameterized.Parameter(value = 1)
    public int numberB;

    @Parameterized.Parameter(value = 2)
    public String expectedResult;

    @Parameterized.Parameters(name = "Test [index]:  {0} - {1} + {2}")
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{{1, 2, "-1"}, {2, 3, "-1"}, {7, 3, "4"}, {20, 3, "17"}, {10, 3, "7"}});
    }

    @Test
    public  void shouldAddSuccessedExcecuteTest(){
        //Given
        Calculator calculator = new CalculatorImpl() {


            @Override
            public void pressNumber(Object number) {

            }
        };
        //When
        calculator.add(numberA,numberB);
        //Then
        String resultDisplay = calculator.display();
        Assertions.assertEquals(expectedResult,resultDisplay);
    }


}
