package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstStepTest {
  @Test
  void whenInputStringIsEmpty_ThenReturnZero(){
    //Arrange
    String input = "";

    //Act
    String sum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "0.0";
    assertEquals(expectedSum, sum);
  }

  @Test
  void whenInputStringHasOneChar_ThenReturnThatChar(){
    //Arrange
    String input = "5";

    //Act
    String sum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "5.0";
    assertEquals(expectedSum, sum);
  }

  @Test
  void whenInputStringHasMoreThanOneChar_ThenReturnTheirSum(){
    //Arrange
    String input = "5,6";

    //Act
    String sum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "11.0";
    assertEquals(expectedSum, sum);
  }

  @Test
  void whenInputStringHasDecimalDigits_ThenReturnOneDecimalDigit(){
    //Arrange
    String input = "1.1,2.2";

    //Act
    String sum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "3.3";
    assertEquals(expectedSum, sum);
  }

}
