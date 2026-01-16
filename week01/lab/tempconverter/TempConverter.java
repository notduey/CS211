package week01.lab.tempconverter;

public class TempConverter {
    public double toFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException();
        }
        return 9.0 / 5.0 * celsius + 32; // formula F = 9/5 * C + 32
    }
}
