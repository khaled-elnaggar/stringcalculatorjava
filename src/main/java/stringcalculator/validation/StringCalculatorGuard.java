package stringcalculator.validation;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorGuard {
  public static void validateNoMissingNumbers(String numbers) {
    Pattern pattern = Pattern.compile("(\n,|,\n|,,|\n\n)");
    Matcher matcher = pattern.matcher(numbers);
    if (matcher.find()) {
      throw new InvalidInputException(ErrorMessages.missingNumberDefaultMessage);
    }
  }

}
