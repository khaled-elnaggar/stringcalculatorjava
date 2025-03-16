package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstStepTests {
    @Test
    void whenStringIsEmpty_ThenReturn0() {
        //Arrange
        String input = "";

        //Act
        String actualSum = StringCalculator.getString(input);

        //Assert
        String expected = "0.0";
        assertEquals(expected, actualSum);
    }

    @Test
    void whenStringHasSingleNumber_ThenReturnThatNumber() {
        //Arrange
        String input = "5";

        //Act
        String actualSum = StringCalculator.getString(input);

        //Assert
        String expected = "5.0";
        assertEquals(expected, actualSum);
    }

    @Test
    void whenStringHasTwoNumbers_ThenReturnTheirSum() {
        //Arrange
        String input = "1,2";

        //Act
        String actualSum = StringCalculator.getString(input);

        //Assert
        String expected = "3.0";
        assertEquals(expected, actualSum);
    }

    @Test
    void whenStringMultipleDecimalDigits_ThenTruncateAfterTheFirstDigit() {
        //Arrange
        String input = "1.24,1.24";

        //Act
        String actualSum = StringCalculator.getString(input);

        //Assert
        String expected = "2.4";
        assertEquals(expected, actualSum);
    }

}
