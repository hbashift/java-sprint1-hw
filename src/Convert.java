public class Convert {
    private double stepKmRatio = 0.00075;
    private double stepKCalRatio = 0.05;

    // конвертирование в километры
    public double convertToKm(int steps) {
        return steps * stepKmRatio;
    }
    // конвертирование в килокалории
    public double convertToCal(int steps) {
        return steps * stepKCalRatio;
    }
}