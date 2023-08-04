package stringcalculator;

public class CustomSeparatorExtractor {
  private String separator;
  private String numbers;
  private boolean found;

  public CustomSeparatorExtractor(String numbers) {
    this.separator = StringCalculator.defaultSeparator;
    this.numbers = numbers;

    if (numbers.startsWith("//")) {
      extractPattern(numbers);
    }

  }

  private void extractPattern(String numbers) {
    int newlineIndex = numbers.indexOf("\n");
    this.separator = numbers.substring(2, newlineIndex);
    this.numbers = numbers.substring(newlineIndex + 1);
    this.found = true;
  }

  public String getSeparator() {
    return separator;
  }

  public String getNumbers() {
    return numbers;
  }

  public boolean isFound() {
    return found;
  }
}
