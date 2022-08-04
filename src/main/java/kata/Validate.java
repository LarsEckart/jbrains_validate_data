package kata;

class Validate {

  private final int number;

  private Validate(int number) {
    this.number = number;
  }

  public static Validate validateThat(int number) {
    return new Validate(number);
  }

  public boolean isOdd() {
    return this.number % 2 != 0;
  }

  public boolean isEven() {
    return this.number % 2 == 0;
  }

  public boolean isBetween(int low, int high) {
    return low < number && number < high;
  }
}
