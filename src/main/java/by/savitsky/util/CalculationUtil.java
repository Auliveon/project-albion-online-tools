package by.savitsky.util;

public class CalculationUtil {

    public static double addPercent(double source, double percent) {
        return source + (source * percent / 100);
    }

    public static double addPercent(int source, double percent) {
        return addPercent((double) source, percent);
    }

    public static int getPercentFromCount(int total, double percent) {
        return (int) (total * percent);
    }

}
