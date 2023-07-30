package stringcalculator;


public class StringCalculator {
  public String add(String numbers) {

    if (numbers.isEmpty()) {
      return "0.0";
    }

    String[] stringNumbers = numbers.split(",");
    if (stringNumbers.length == 1) {
      return formatToOneDecimalDigit(Double.parseDouble(stringNumbers[0]));
    }

    double sum = Double.parseDouble(stringNumbers[0]) + Double.parseDouble(stringNumbers[1]);
    return formatToOneDecimalDigit(sum);
  }

  private static String formatToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }
}
