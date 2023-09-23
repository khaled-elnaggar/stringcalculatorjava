package stringcalculator;

import java.util.Arrays;

public class StringCalculator {

  public static String sum(String input) {
    if (input.isEmpty()) {
      return "0.0";
    }

    double sum = Arrays.stream(input.split(","))
            .mapToDouble(Double::parseDouble)
            .sum();

    return String.format("%.1f", sum);
  }
}
