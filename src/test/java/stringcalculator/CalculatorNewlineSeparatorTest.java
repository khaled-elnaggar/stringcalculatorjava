package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorNewlineSeparatorTest {
  StringCalculator stringCalculator = new StringCalculator();

  @ParameterizedTest
  @ValueSource(strings = {"1\n2.5,3", "1.5\n2\n3", "1,2\n3.5"})
  void whenAddingNumbersSeparatedByNewlines_ReturnTheirSum(String numbers) {
    //Arrange
    //Act
    String actualSum = stringCalculator.add(numbers);

    //Assert
    String expectedSum = "6.5";
    assertEquals(expectedSum, actualSum);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1\n,2,3", "1,\n2\n3", "1,,2\n3", "1\n\n2,3"})
  void whenAddingAStringMissingNumberBetweenSeparators_ReturnInvalidInputError(String numbers) {
    //Arrange

    //Act
    //Assert
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class,
            () -> stringCalculator.add(numbers));

    assertEquals(ErrorMessages.missingNumberDefaultMessage, invalidInputException.getMessage());
  }

}
