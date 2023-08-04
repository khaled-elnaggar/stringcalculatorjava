package stringcalculator;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;
import stringcalculator.validation.StringCalculatorGuard;

import java.util.Arrays;

public class StringCalculator {
  public static String defaultSeparator = ",";

  public String add(String numbers) {
    CustomSeparatorExtractor separatorExtractor = new CustomSeparatorExtractor(numbers);
    String separator = separatorExtractor.getSeparator();
    numbers = separatorExtractor.getNumbers();

    StringCalculatorGuard.validateNoMissingNumbers(separator, numbers);

    if (separatorExtractor.isFound()) {
      StringCalculatorGuard.validateNotMixingCustomAndDefaultSeparators(numbers);
    }

    return addNumbers(numbers, separator);
  }

    private String addNumbers(String numbers, String separator) {
    if (numbers.isEmpty()) {
      return "0.0";
    }
    String[] stringNumbers = numbers.split(String.format("%s|\n", separator));
    double sum = calculateSum(stringNumbers);
    return formatToOneDecimalDigit(sum);
  }

  private double calculateSum(String[] stringNumbers) {
    try {
      return Arrays.stream(stringNumbers).mapToDouble(Double::parseDouble).sum();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException(ErrorMessages.nonNumberErrorMessage);
    }
  }

  private String formatToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }
}
