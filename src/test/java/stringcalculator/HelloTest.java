package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {

  @Test
  void testSystemInit() {
    assertEquals("Hello World!", Hello.getGreeting());
  }
}
