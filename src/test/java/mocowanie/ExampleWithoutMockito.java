package mocowanie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleWithoutMockito {

    List<String> mockedList;

    @Before
    public void before(){
        mockedList = new ArrayList<>();// tworzymy prawdziwą listę
    }

    @Test
    public void whenUseMockAnnotationMockInject(){
        mockedList.add("one");// dodajemy tylko jedna wartosc
        assertEquals(1,mockedList.size());
    }
}
