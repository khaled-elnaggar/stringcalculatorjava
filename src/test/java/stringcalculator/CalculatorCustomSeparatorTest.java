package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.errors.ErrorMessages;
import stringcalculator.errors.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorCustomSeparatorTest {
  StringCalculator stringCalculator = new StringCalculator();

  @ParameterizedTest
  @ValueSource(strings = {"//;\n1.8;2.4;3.2", "//sep\n4.7sep2.7"})
  void whenAddingAnEmptyString_ReturnZero(String numbers) {
    //Given
    //When
    String actualSum = stringCalculator.add(numbers);

    //Then
    final String expectedSum = "7.4";
    assertEquals(expectedSum, actualSum);
  }


  @Test
  void whenAddingAStringWithACustomSeparator_ButUsingDefaultSeparatorToo_ThenReturnInvalidInputException() {
    //Given
    String numbers = "//x\n1x2,3";
    
    //When & Then
    InvalidInputException exception = assertThrows(InvalidInputException.class,
            () -> stringCalculator.add(numbers));

    assertEquals(ErrorMessages.mixingCustomAndDefaultSeparators, exception.getMessage());
  }

  @Test
  void whenAddingAStringWithACustomSeparator_ButMissingNumbers_ThenReturnInvalidInputException() {
    //Given
    String numbers = "//x\n1x2xx3";

    //When & Then
    InvalidInputException exception = assertThrows(InvalidInputException.class,
            () -> stringCalculator.add(numbers));

    assertEquals(ErrorMessages.missingNumberDefaultMessage, exception.getMessage());
  }


}
