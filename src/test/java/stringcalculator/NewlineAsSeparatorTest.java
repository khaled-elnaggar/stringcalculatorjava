package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NewlineAsSeparatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"1\n2,3", "1\n2\n3", "1,2\n3"})
  void whenAddingStringWithNewlineSeparator_thenReturnTheirSumWith1DecimalDigit(String input) {
    //Arrange
    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "6.0";
    assertEquals(expectedSum, actualSum);
  }


  @ParameterizedTest
  @ValueSource(strings = {"1,\n2", "1\n,2", "1,,2", "1\n\n2"})
  void whenAddingStringWithMissingNumbersBetweenSeparator_thenReturnError(String input) {
    //Arrange
    //Act & Assert
    InvalidInputException exception = assertThrows(InvalidInputException.class,
            () -> StringCalculator.sum(input));

    assertEquals(ErrorMessages.NUMBER_EXPECTED_BUT_FOUND_SEPARATOR, exception.getMessage());
  }

}
