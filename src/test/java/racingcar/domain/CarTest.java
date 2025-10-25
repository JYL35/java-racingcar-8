package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void 자동차_생성() {
        car = new Car(new CarName("even"));
    }

    @Test
    @DisplayName("Car 객체 생성 시, 이름을 부여하고 0의 위치를 가진다")
    void test_자동차_생성_확인() {
        String resultName = "even";
        String resultDistance = "";

        assertThat(car.getName()).isEqualTo(resultName);
        assertThat(car.getDistanceMoved()).isEqualTo(resultDistance);
    }
}
