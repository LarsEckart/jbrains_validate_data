package kata;

import static kata.Validate.validateThat;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.larseckart.tcr.CommitOnGreenExtension;
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

  @Test
  void positive_number_is_positive() {
    assertThat(validateThat(1).isPositive()).isTrue();
  }

  @Test
  void negative_number_is_not_positive() {
    assertThat(validateThat(-2).isPositive()).isFalse();
  }

  @Test
  void zero_is_not_positive() {
    assertThat(validateThat(0).isPositive()).isFalse();
  }

  @Test
  void zero_is_not_negative() {
    assertThat(validateThat(0).isNegative()).isFalse();
  }
}
