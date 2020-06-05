package testy;

public class CalculatorImpl implements Calculator {
    String display;
    public CalculatorImpl(){clear();}
    @Override
    public void pressNumber(Object number) {
        StringBuilder stringBuilder = new StringBuilder();
        display = stringBuilder.append(display).append(number).toString();

    }
    @Override
    public String display() {
        // zwróć stan wyświetlacza
        return display;
    }
    @Override
    public void add(int numberA, int numberB) {
        int result = numberA + numberB;
        pressNumber(result);
    }
    @Override
    public void sub(int numberA, int numberB) {
        pressNumber(numberA - numberB);
    }
    @Override
    public void div(int numberA, int numberB) {
        // implementacje zrzucanie wyjatku IllegalArgumentException
        // podczas dzielenia przez zero
        if (numberB == 0) {
            throw new IllegalArgumentException(display);
        } else {
            pressNumber(numberA / numberB);
        }
    }
    @Override
    public void multi(int numberA, int numberB) {
        pressNumber(numberA * numberB);
    }
    @Override
    public void clear() {

    }

    @Override
    public void isEven(int number) {
        pressNumber(number%2==0);
    }
}
