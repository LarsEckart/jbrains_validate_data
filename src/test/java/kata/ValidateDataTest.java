package kata;

import static kata.Validate.validateThat;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.larseckart.tcr.CommitOnGreenExtension;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(CommitOnGreenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidateDataTest {

  @ParameterizedTest
  @ValueSource(ints = {3, 5, -1})
  void odd_numbers_are_odd(int input) {
    assertThat(validateThat(input).isOdd()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 6, 0, -2})
  void even_numbers_are_not_odd(int input) {
    assertThat(validateThat(input).isOdd()).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 5, -1})
  void odd_numbers_are_not_even(int input) {
    assertThat(validateThat(input).isEven()).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 6, 0, -2})
  void even_numbers_are_even(int input) {
    assertThat(validateThat(input).isEven()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"""
      5,2,8
      1,0,2
      -4,-5,-1
      """})
  void number_is_between(int number, int low, int high) {
    assertThat(validateThat(number).isBetween(low, high)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"""
      1,1,10
      10,1,10
      """})
  void number_is_between_is_exclusive(int number, int low, int high) {
    assertThat(validateThat(number).isBetween(low, high)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 65, 1})
  void positive_number_is_positive(int input) {
    assertThat(validateThat(input).isPositive()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {-2, -65, -1})
  void negative_number_is_not_positive(int input) {
    assertThat(validateThat(input).isPositive()).isFalse();
  }

  @Test
  void zero_is_not_positive() {
    assertThat(validateThat(0).isPositive()).isFalse();
  }

  @Test
  void zero_is_not_negative() {
    assertThat(validateThat(0).isNegative()).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {3, 15, 103})
  void positive_number_is_not_negative(int input) {
    invalidCase(() -> validateThat(input).isNegative());
  }

  private static void invalidCase(Supplier<Boolean> f) {
    assertThat(f.get()).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {-23, -55, -1})
  void negative_number_is_negative(int input) {
    assertThat(validateThat(input).isNegative()).isTrue();
  }
}
