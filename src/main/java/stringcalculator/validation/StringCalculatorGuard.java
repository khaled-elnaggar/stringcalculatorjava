package stringcalculator.validation;

import stringcalculator.StringCalculator;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorGuard {

  public static void validateNoMissingNumbers(String separator, String numbers) {
    Pattern pattern = Pattern.compile(String.format("(\n%s|%s\n|%s%s|\n\n)", separator, separator, separator, separator));
    Matcher matcher = pattern.matcher(numbers);
    if (matcher.find()) {
      throw new InvalidInputException(ErrorMessages.missingNumberDefaultMessage);
    }
  }

  public static void validateNotMixingCustomAndDefaultSeparators(String numbers) {
    if (numbers.contains(StringCalculator.defaultSeparator)) {
      throw new InvalidInputException(ErrorMessages.mixingCustomAndDefaultSeparators);
    }
  }

  public static void validateNoNegativeNumbers(double[] doubles) {
    double[] negatives = Arrays.stream(doubles).filter(n -> n < 0).toArray();

    if (negatives.length > 0) {
      throw new InvalidInputException(ErrorMessages.negativeNumbersNotAllowed + Arrays.toString(negatives));
    }
  }
}
