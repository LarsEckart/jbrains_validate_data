package kata;

class Validate {

  private final int number;

  private Validate(int number) {
    this.number = number;
  }

  public static Validate validateThat(int number) {
    return new Validate(number);
  }

  public boolean isBetween(int low, int high) {
    return low < number && number < high;
  }
}
