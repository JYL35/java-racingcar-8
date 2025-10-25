package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRosterTest {

    @ParameterizedTest
    @DisplayName("정상적인 이름 목록인 경우 예외 없이 생성된다")
    @ValueSource(strings = {"even ,pobi, woni,30", "1,2, 3", "a, b , c"})
    void test_정상_이름_테스트(String testInput) {
        assertThatNoException().isThrownBy(() -> new CarRoster(testInput));
    }

    @ParameterizedTest
    @DisplayName("차 이름이 1개 이하인 경우")
    @ValueSource(strings = {"even", "", " ", " , ,"})
    void test_1대_이하_예외발생(String testInput) {
        assertThatThrownBy(() -> new CarRoster(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("중복되는 차 이름이 있는 경우")
    @ValueSource(strings = {"even,pobi,even", "a, b, a", " 1, 2 , 2"})
    void test_중복_이름_예외발생(String testInput) {
        assertThatThrownBy(() -> new CarRoster(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
