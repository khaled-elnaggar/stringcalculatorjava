package stringcalculator;

import org.junit.jupiter.api.Test;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorNegativeNumbersTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  void whenAddingManyNumbers_ReturnTheirSum() {
    //Given
    String numbers = "1.1,-2.2,-3";


    //When & Then
    InvalidInputException exception = assertThrows(InvalidInputException.class,
            () -> stringCalculator.add(numbers));

    String expectedErrorMessage = ErrorMessages.negativeNumbersNotAllowed + "[-2.2, -3.0]";
    assertEquals(expectedErrorMessage, exception.getMessage());
  }

}
