package kata;

class Validate {

  private final int number;

  private Validate(int number) {
    this.number = number;
  }

  public static Validate validateThat(int number) {
    return new Validate(number);
  }

  public static boolean validateEven(int input) {
    return !validateOdd(input);
  }

  public static boolean validateOdd(int number) {
    return validateThat(number).isOdd();
  }

  private boolean isOdd() {
    return this.number % 2 != 0;
  }

  public static boolean validateBetween(int number, int low, int high) {
    return low < number && number < high;
  }

  public boolean isBetween(int low, int high) {
    return low < number && number < high;
  }
}
