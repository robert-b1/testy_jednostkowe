package mocowanie;

import testy.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoAnnotationMockTest {

    /**
     * Mockowanie listy - tworzenie atrapy @Mock
     * nie zainicjalizowana przyszla atrapa
     */
    @Mock
    List<String> mockedList;// deklaracja listy zamockowanej

    @Before
    public void before(){
        //inicjowanie mockowania
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUseMockAnnotationMockInject(){
        mockedList.add("one");// dodajemy tylko jedna wartosc
        assertEquals(0,mockedList.size());// mamy zero
        // atrapa nie ma zachowania na pobieranie rozmiaru
    }

    @Test
    public void whenUseMockAnnotationMockInject2(){
        mockedList.add("one");// dodajemy tylko jedna wartosc

        // weryfikujemy czy do mock listy zostala dodana wartosc "one"
        verify(mockedList).add("one");
        //verify(mockedList).add("two");

        when(mockedList.size()).thenReturn(1);
        assertEquals(1,mockedList.size());
    }

    @Test
    public void whenUseMockAnnotationMockInject3(){
        //mockedList.add("one");// dodajemy tylko jedna wartosc

        // kiedy pytasz mockedList o size zwróć 2020
        when(mockedList.size()).thenReturn(2020);

        // asercje czy size jest równy 2020
        assertEquals(mockedList.size(),2020);
    }

    @Test
    public void whenUseMockAnnotationMockList4(){
        // mockedList - polem w klasie
        // przez co jest widoczne w każdej metodzie/teście
        List onlyHereMockList = mock(ArrayList.class);

        onlyHereMockList.add("one");
        verify(onlyHereMockList).add("one");

        when(onlyHereMockList.size()).thenReturn(1);// powiedzielismy atrapie ze ma rozmiar 1
        assertEquals(1,onlyHereMockList.size());
    }

    @Test
    public void  addThreeTimesElementToList(){
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three");

        // weryfikujemy czy do listy dodaliśmy jakiś anyString 3 razy
        verify(mockedList, times(3)).add(anyString());

        // weryfikujemy czy "one" został dodany tylko raz
        verify(mockedList, times(1)).add("one");
    }

    /**
     * Zadanie!
     */
    @Test
    public void calculatorMockitoTest(){
        // zdefiniować atrape Calculator
        Calculator calc = mock(Calculator.class);

        // atrapa kalkulatora wyswietlala 2020
        // zamockować metodę display()
        when(calc.display()).thenReturn("2020");

        // sout i wypisać display()
        System.out.println(calc.display());

        // zweryfikuj czy metoda display wykonala się tylko raz
        verify(calc, times(1)).display();

        // zweryfikuj używając metody never() czy metoda pressNumber()
        // nigdy się nie wykonała
        verify(calc, never()).pressNumber(any(Object.class));
    }
}
