package testy;

public interface Calculator {
    /**
     * Metoda odpowiedzialna za wcisniecie przycisku z cyfrą
     * @param number
     */

    void pressNumber(Object number);

    /**
     * Metoda odpowiedzialna za pobranie zawartości wyświetlacza
     * @return
     */
    String display();

    /**
     * Metoda dodaje numberA do numberB
     * @param numberA pierwsza liczba
     * @param numberB druga liczba
     */
    public void add(int numberA, int numberB);

    /**
     * Metoda odejmuje numberA od numberB
     * @param numberA pierwsza liczba
     * @param numberB druga liczba
     */
    public void sub(int numberA, int numberB);

    /**
     * Metoda dzieli numberA przez numberB
     * @param numberA pierwsza liczba
     * @param numberB druga liczba
     */
    public void div(int numberA, int numberB);

    /**
     * Metoda mnoży numberA przez numberB
     * @param numberA pierwsza liczba
     * @param numberB druga liczba
     */
    public void multi(int numberA, int numberB);

    /**
     * Metoda czyści zawartość wyświetlacza
     */
    void clear();

    void isEven(int number);
}
