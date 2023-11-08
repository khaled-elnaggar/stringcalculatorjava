package stringcalculator;

import java.util.Arrays;

public class StringCalculator {

  public static String sum(String input) {
    if (input.isEmpty()) {
      return "0.0";
    }

    String[] strNumbers = input.split(",");
    double sum = calculateSum(strNumbers);
    return formatDoubleToOneDecimalDigit(sum);
  }

  private static double calculateSum(String[] strNumbers) {
    try {
      return Arrays.stream(strNumbers)
              .mapToDouble(Double::parseDouble)
              .sum();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException(ErrorMessages.NUMBER_EXPECTED_BUT_NON_NUMBER_FOUND);
    }
  }

  private static String formatDoubleToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }
}
