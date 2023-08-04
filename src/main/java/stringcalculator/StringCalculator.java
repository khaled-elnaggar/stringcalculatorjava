package stringcalculator;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;
import stringcalculator.validation.StringCalculatorGuard;

import java.util.Arrays;

public class StringCalculator {

  public String add(String numbers) {
    StringCalculatorGuard.validateNoMissingNumbers(numbers);
    return addNumbers(numbers);
  }

  private String addNumbers(String numbers) {
    if (numbers.isEmpty()) {
      return "0.0";
    }
    String[] stringNumbers = numbers.split("[,\n]");
    double sum = calculateSum(stringNumbers);
    return formatToOneDecimalDigit(sum);
  }

  private double calculateSum(String[] stringNumbers) {
    try {
      double[] doubles = Arrays.stream(stringNumbers).mapToDouble(Double::parseDouble).toArray();
      StringCalculatorGuard.validateNoNegativeNumbers(doubles);
      return Arrays.stream(doubles).sum();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException(ErrorMessages.nonNumberErrorMessage);
    }
  }

  private String formatToOneDecimalDigit(double sum) {
    return String.format("%.1f", sum);
  }
}
