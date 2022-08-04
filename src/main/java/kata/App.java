package kata;

import java.io.IOException;

class App {

  public static void main(String[] args) throws IOException {
  }

  public static boolean validateOdd(int number) {
    return number % 2 != 0;
  }

  public static boolean validateBetween(int number, int low, int high) {
    return low < number && number < high;
  }
}
