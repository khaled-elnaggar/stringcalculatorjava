package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorManyNumbersTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  void whenAddingManyNumbers_ReturnTheirSum() {
    //Arrange
    String numbers = "1.1,2.2,3";

    //Act
    String actualSum = stringCalculator.add(numbers);

    //Assert
    String expectedSum = "6.3";
    assertEquals(expectedSum, actualSum);
  }
}
