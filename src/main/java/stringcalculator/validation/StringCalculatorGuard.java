package stringcalculator.validation;

import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import java.util.List;

public class StringCalculatorGuard {

  public static void validateNoMissingNumber(String input) {
    List<String> missingNumberPatterns = List.of("\n,", ",\n", "\n\n", ",,");
    if (missingNumberPatterns.stream().anyMatch(input::contains)) {
      throw new InvalidInputException(ErrorMessages.NUMBER_EXPECTED_BUT_FOUND_SEPARATOR);
    }
  }
}
