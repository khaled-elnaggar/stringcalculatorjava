package stringcalculator;

public class StringCalculator {

    public static String getString(String input) {
        if (input.isEmpty()) {
            return "0.0";
        }

        String[] stringNumbers = input.split(",");
        double sum = sumStringNumbers(stringNumbers);
        return roundSumToOneDigit(sum);
    }

    private static String roundSumToOneDigit(double sum) {
        return String.format("%.1f", sum);
    }

    private static double sumStringNumbers(String[] stringNumbers) {
        double sum = Double.parseDouble(stringNumbers[0]);

        if (stringNumbers.length > 1) {
            sum += Double.parseDouble(stringNumbers[1]);
        }
        return sum;
    }
}
