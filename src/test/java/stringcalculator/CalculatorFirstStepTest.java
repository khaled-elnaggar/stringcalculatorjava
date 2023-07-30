package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorFirstStepTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  void whenAddingAnEmptyString_ReturnZero() {
    //Arrange
    final String number = "";

    //Act
    String actualSum = stringCalculator.add(number);

    //Assert
    final String expectedSum = "0.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingOneNumber_ReturnThatNumber() {
    //Arrange
    final String number = "5";

    //Act
    String actualSum = stringCalculator.add(number);

    //Assert
    final String expectedSum = "5.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingTwoNumbers_ReturnTheirSum() {
    //Arrange
    String numbers = "5,3";

    //Act
    String actualSum = stringCalculator.add(numbers);

    //Assert
    String expectedSum = "8.0";
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void whenAddingTwoDecimals_ReturnTheirSumWithOneDecimalDigit() {
    //Arrange
    String numbers = "1.121,1.6";

    //Act
    String actualSum = stringCalculator.add(numbers);

    //Assert
    String expectedSum = "2.7";
    assertEquals(expectedSum, actualSum);
  }

}
