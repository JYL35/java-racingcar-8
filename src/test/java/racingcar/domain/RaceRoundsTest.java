package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceRoundsTest {

    @ParameterizedTest
    @DisplayName("정상적인 라운드 수(문자열)인 경우 객체 생성")
    @ValueSource(strings = {"1", "3", "10"})
    void test_정상적인_숫자인경우_생성(String testCount) {
        assertThatNoException().isThrownBy(() -> new RaceRounds(testCount));

        RaceRounds raceRounds = new RaceRounds(testCount);

        assertThat(raceRounds.getCount()).isEqualTo(Integer.parseInt(testCount));
    }

    @ParameterizedTest
    @DisplayName("라운드 수가 빈 문자열, 공백 또는 Null 값이면 예외 발생")
    @ValueSource(strings = {"", " ", "   "})
    @NullSource
    void test_라운드수_널값_예외발생(String testCount) {
        assertThatThrownBy(() -> new RaceRounds(testCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("라운드 수가 정수가 아닌 경우 예외 발생")
    @ValueSource(strings = {"a", "abc", "1.3", " 7"})
    void test_라운드수_문자_예외발생(String testCount) {
        assertThatThrownBy(() -> new RaceRounds(testCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("라운드 수가 1미만이면 예외 발생")
    @ValueSource(strings = {"0", "-2"})
    void test_라운드수_1미만_예외발생(String testCount) {
        assertThatThrownBy(() -> new RaceRounds(testCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
