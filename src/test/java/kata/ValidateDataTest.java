package kata;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.larseckart.tcr.CommitOnGreenExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CommitOnGreenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidateDataTest {

  @Test
  void odd_numbers_are_odd() {
    assertThat(App.validateOdd(3)).isTrue();
  }

  @Test
  void even_numbers_are_not_odd() {
    assertThat(App.validateOdd(4)).isFalse();
  }

}
