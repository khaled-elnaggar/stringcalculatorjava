package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManyNumbersTest {
  @Test
  void whenInputStringHasMoreThanTwoChars_ThenReturnTheirSum(){
    //Arrange
    String input = "1,2,3,4";

    //Act
    String sum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "10.0";
    assertEquals(expectedSum, sum);
  }

  @Test
  void whenInputStringContainsNonNumber_ThenReturnInvalidInputError(){
    //Arrange
    String input = "1,a,2";

    //Act
    //Assert
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class,
            () -> StringCalculator.sum(input));

    String expectedErrorMessage = ErrorMessages.NUMBER_EXPECTED_BUT_NON_NUMBER_FOUND;
    assertEquals(expectedErrorMessage, invalidInputException.getMessage());
  }

}
