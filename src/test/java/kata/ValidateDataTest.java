package kata;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.larseckart.tcr.CommitOnGreenExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(CommitOnGreenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidateDataTest {

  @ParameterizedTest
  @ValueSource(ints = {3, 5, -1})
  void odd_numbers_are_odd() {
    assertThat(App.validateOdd(3)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 6, 0, -2})
  void even_numbers_are_not_odd() {
    assertThat(App.validateOdd(4)).isFalse();
  }

}
