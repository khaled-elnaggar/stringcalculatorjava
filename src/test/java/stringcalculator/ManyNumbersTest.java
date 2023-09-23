package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManyNumbersTest {

  @Test
  void whenAddingStringWithManyNumbers_thenReturnTheirSumWith1DecimalDigit() {
    //Arrange
    String input = "1.1111,2.2,3,4";

    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "10.3";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingStringWithNonNumberCharacter_thenReturnError() {
    //Arrange
    String input = "1,x,2";

    InvalidInputException exception = assertThrows(InvalidInputException.class,
            () -> StringCalculator.sum(input));

    assertEquals(ErrorMessages.NUMBERS_EXPECTED_BUT_FOUND_NON_NUMBER, exception.getMessage());
  }

}
