package mocowanie;

import testy.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoAnnotationCaptorTest {

    @Mock
    List mockedListObject;

    @Captor
    ArgumentCaptor argumentCaptor;

    @Before
    public void before(){
        // inicjalizacja atrap wykorzystanych w tej klasie (this)
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUseCaptorAnntationInjectTest(){
        mockedListObject.add("one");

        // konfiguracja przechwytywacz
        verify(mockedListObject).add(argumentCaptor.capture());

        // getValue() zwróć co przechwyciłeś
        assertEquals(argumentCaptor.getValue(),"one");
    }

    @Test
    public void whenUseCaptorAnnotationInMethodTest(){
        // inicjalizacja mock listy
        List mockListHere = mock(List.class);

        // konfiguracja przechwytywacz
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        mockListHere.add("two");

        // przechwycamy element
        verify(mockListHere).add(argumentCaptor.capture());

        // pobieramy i sprawdzamy wartość
        assertEquals("two",argumentCaptor.getValue());
    }


    @Test
    public void whenUseCaptorAnnotationCalcTest(){
        // inicjalizacja mock Calculatora
        Calculator calc = mock(Calculator.class);

        // konfiguracja przechwytywacz
        ArgumentCaptor<Object> argumentCaptor = ArgumentCaptor.forClass(Object.class);

        // wywołanie pressNumber()
        calc.pressNumber("3");

        // przechwycamy element
        verify(calc).pressNumber(argumentCaptor.capture());

        // pobieramy i sprawdzamy wartość
        assertEquals(3,argumentCaptor.getValue());
    }
}
