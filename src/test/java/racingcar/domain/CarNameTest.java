package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("이름이 1에서 5사이의 글자수면 정상적으로 생성")
    void test_이름_생성() {
        String testName = "Even";

        CarName carName = new CarName(testName);

        assertThat(carName.getName()).isNotNull();
        assertThat(carName.getName()).isEqualTo(testName);
    }

    @ParameterizedTest
    @DisplayName("이름이 빈 문자열, 공백 또는 Null 값이면 예외 발생")
    @ValueSource(strings = {"", " ", "   "})
    @NullSource
    void test_공백_또는_널값_예외발생(String testName) {
        assertThatThrownBy(() -> new CarName(testName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외 발생")
    void test_글자수_초과_예외발생() {
        String testName = "abcdef";

        assertThatThrownBy(() -> new CarName(testName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
