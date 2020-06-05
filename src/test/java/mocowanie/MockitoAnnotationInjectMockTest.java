package mocowanie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoAnnotationInjectMockTest {

    @Before
    public void before(){
        // inicjalizacja atrap wykorzystanych w tej klasie (this)
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Dane słownika zamokowane
     */
    @Mock
    Map<String,String> wordMap; // słowa

    /**
     * Słownik który ma wstrzyknięte słowa z wordMap
     */
    @InjectMocks
    MyDictionary dic = new MyDictionary();

    public class MyDictionary{

        Map<String,String> wordMap;

        public MyDictionary(Map<String,String> wordMap){
            this.wordMap = wordMap;
        }

        public MyDictionary(){
            wordMap = new HashMap<>();
        }

        /**
         * Pobieraniu słowa z mapy słów
         * @param word słowo którego szukamy
         * @return tłumaczenie z mapy słów
         */
        public String getTranslation(String word){
            return wordMap.get(word);
        }
    }

    @Test
    public void whenUseInjectMocksAnnotationTest(){
        // jak ma działać wordMap - mockowanie
        when(wordMap.get("Help")).thenReturn("Pomocy");
        when(wordMap.get("Programmer")).thenReturn("Programista");

        // weryfikacja działania MyDictionary ze wstrzykniętymi słowami
        assertEquals("Pomocy",dic.getTranslation("Help"));
        assertEquals("Programista",dic.getTranslation("Programmer"));
    }
}
