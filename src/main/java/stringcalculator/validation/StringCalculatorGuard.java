package stringcalculator.validation;

import stringcalculator.StringCalculator;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

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
}
