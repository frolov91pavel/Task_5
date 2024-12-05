public class CalculatorImpl implements Calculator {

    private String version;

    public CalculatorImpl() {

    }

    public CalculatorImpl(String version) {
        this.version = version;
    }

    @Override
    public int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}