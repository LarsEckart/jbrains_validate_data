package kata;

import static kata.Validate.validateBetween;
import static kata.Validate.validateThat;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.larseckart.tcr.CommitOnGreenExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
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

  @Test
  void five_is_between_2_and_8() {
    assertThat(validateBetween(5, 2, 8)).isTrue();
  }

  @Test
  void five_is_between_2_and_8_with_Validate_object() {
    assertThat(validateThat(5).isBetween(2, 8)).isTrue();
  }

}
