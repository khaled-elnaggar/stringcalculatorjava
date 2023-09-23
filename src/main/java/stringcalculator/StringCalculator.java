package stringcalculator;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;
import stringcalculator.validation.StringCalculatorGuard;

import java.util.Arrays;

public class StringCalculator {

  public static String sum(String input) {
    StringCalculatorGuard.validateNoMissingNumber(input);

    if (input.isEmpty()) {
      return "0.0";
    }

    double sum = calculateSum(input);
    return formatToOneDecimalDigit(sum);
  }

  private static double calculateSum(String input) {
    try {
      return Arrays.stream(input.split("[,\n]"))
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
