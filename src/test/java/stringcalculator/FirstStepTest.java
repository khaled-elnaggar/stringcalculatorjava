package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstStepTest {
  @Test
  void whenAddingEmptyString_thenReturnZero(){
    //Arrange
    String input = "";

    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "0.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingStringWithOneNumber_thenReturnThatNumber() {
    //Arrange
    String input = "5";

    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "5.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingStringWithTwoNumbers_thenReturnTheirSum() {
    //Arrange
    String input = "1,2";

    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "3.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingStringWithTwoNumbers_thenReturnTheirSumWith1DecimalDigit() {
    //Arrange
    String input = "1.1111,2.2";

    //Act
    String actualSum = StringCalculator.sum(input);

    //Assert
    String expectedSum = "3.3";
    assertEquals(expectedSum, actualSum);
  }


}
