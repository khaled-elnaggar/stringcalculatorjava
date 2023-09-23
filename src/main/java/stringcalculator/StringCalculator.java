package stringcalculator;

import java.util.Arrays;

public class StringCalculator {

  public static String sum(String input) {
    if (input.isEmpty()) {
      return "0.0";
    }

    double sum = calculateSum(input);
    return formatToOneDecimalDigit(sum);
  }

  private static double calculateSum(String input) {
    try {
      return Arrays.stream(input.split(","))
              .mapToDouble(Double::parseDouble)
              .sum();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException(ErrorMessages.NUMBERS_EXPECTED_BUT_FOUND_NON_NUMBER);
    }
  }

  private static String formatToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }

}
