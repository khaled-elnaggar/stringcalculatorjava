package stringcalculator;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import java.util.Arrays;

public class StringCalculator {
  public String add(String numbers) {

    if (numbers.isEmpty()) {
      return "0.0";
    }

    String[] stringNumbers = numbers.split(",");
    double sum = calculateSum(stringNumbers);
    return formatToOneDecimalDigit(sum);
  }

  private static double calculateSum(String[] stringNumbers) {
    try {
      return Arrays.stream(stringNumbers).mapToDouble(Double::parseDouble).sum();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException(ErrorMessages.nonNumberErrorMessage);
    }
  }

  private static String formatToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }
}
