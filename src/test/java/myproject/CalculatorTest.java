package myproject;

import org.hamcrest.junit.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CalculatorTest {

    private Calculator calc;

    @Before
    public void before(){
        //given
        calc = new CalculatorImpl();
    }

    /**
     * Test wcisnięcia przycisku "0" i sprawdzenie
     * czy na wyświetlaczu jest wyświetlone "0"
     */
    @Test
    public void pressNumber0Test(){
        //when
        calc.pressNumber(0);

        //then
        String result = calc.display();
        String expected = "0";

        assertEquals("Must be only zero on display!",expected,result);

    }

    /**
     * Test pustego wyświetlacza
     */
    @Test
    public void emptyDisplayTest(){

        //when
        //nic nie robimy sprawdzamy poniżej wyświetlacz

        //then
        // czy prawdą jest, że kalkulator display jest pusty
        assertTrue("Display must be empty!",calc.display().isEmpty());
    }

    @Test
    public void shouldDisplay7WhenAdd3And4Test(){

        //when
        calc.add(3,4);

        //then
        String resultDisplay = calc.display();
        String expected = "7";
        assertEquals(expected,resultDisplay);
    }

    @Test
    public void shouldDisplay2WhenSub6And4Test(){

        //when
        calc.sub(6,2);

        //then
        String resultDisplay = calc.display();
        String expected = "4";
        assertEquals(expected,resultDisplay);
    }

    @Test
    public void shouldDisplay9WhenDiv81And9Test(){

        //when
        calc.div(81,9);

        //then
        String resultDisplay = calc.display();
        String expected = "9";
        assertEquals(expected,resultDisplay);
    }

    @Test
    public void shouldDisplay12WhenMulti3And4Test(){

        //when
        calc.multi(3,4);

        //then
        String resultDisplay = calc.display();
        String expected = "12";
        assertEquals(expected,resultDisplay);
    }

    @Test
    public void clearDisplayTest(){

        //when
        calc.pressNumber(0);
        calc.clear();

        //then
        assertTrue(calc.display().isEmpty());
    }

    /**
     * Test 5 poprawnych przykładów dodawań
     */
    @Test
    public void shouldAddSuccessedExecuteTest(){

        //when1
        calc.clear();
        calc.add(3,4);
        //then1
        assertEquals("7",calc.display());
        //when2
        calc.clear();
        calc.add(1,4);
        //then2
        assertEquals("5",calc.display());
        //when3
        calc.clear();
        calc.add(0,4);
        //then3
        assertEquals("4",calc.display());
        //when4
        calc.clear();
        calc.add(7,4);
        //then4
        assertEquals("11",calc.display());
        //when5
        calc.clear();
        calc.add(9,1);
        //then5
        assertEquals("10",calc.display());

    }

    // ponizej dwa sposoby testowania wyjatków
    @Test
    public void shouldDisplayErrorWhenDivByZeroTest(){

        //when
        try {
            calc.div(81, 0);
        }catch(Exception e){
            //then
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().equals("Nie dziel przez zero"));
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldDisplayRuleErrorWhenDivByZeroTest(){

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Nie dziel przez zero");

        calc.div(2,0);
    }

    @Test
    public void isEvenFalseTest(){
        //when
        calc.isEven(81);

        //then
        String resultDisplay = calc.display();
        String expected = "false";
        assertEquals(expected,resultDisplay);
    }

    @Test
    public void isEvenTrueTest(){
        //when
        calc.isEven(2);

        //then
        String resultDisplay = calc.display();
        String expected = "true";
        assertEquals(expected,resultDisplay);
    }

}
