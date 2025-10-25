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

    @Test
    @DisplayName("무작위 값이 4이상일 경우 전진한다")
    void test_자동차_전진() {
        car.move(4);
        car.move(7);

        String resultDistance = "--";

        assertThat(car.getDistanceMoved()).isEqualTo(resultDistance);
    }

    @Test
    @DisplayName("무작위 값이 3이하일 경우 멈춘다")
    void test_자동차_멈춤() {
        car.move(3);
        car.move(1);

        String resultDistance = "";

        assertThat(car.getDistanceMoved()).isEqualTo(resultDistance);
    }
}
