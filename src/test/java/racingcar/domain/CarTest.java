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
        int resultPosition = 0;

        assertThat(car.getName()).isEqualTo(resultName);
        assertThat(car.getPosition()).isEqualTo(resultPosition);
    }

    @Test
    @DisplayName("무작위 값이 4이상일 경우 전진한다")
    void test_자동차_전진() {
        car.move(4);
        car.move(7);

        int resultPosition = 2;

        assertThat(car.getPosition()).isEqualTo(resultPosition);
    }

    @Test
    @DisplayName("무작위 값이 3이하일 경우 멈춘다")
    void test_자동차_멈춤() {
        car.move(3);
        car.move(1);

        int resultPosition = 0;

        assertThat(car.getPosition()).isEqualTo(resultPosition);
    }

    @Test
    @DisplayName("이 자동차가 우승자인지 확인(참)")
    void test_우승자_확인_True() {
        car.move(4);
        car.move(8);

        int winnerPosition = 2;

        assertThat(car.comparePosition(winnerPosition)).isTrue();
    }

    @Test
    @DisplayName("이 자동차가 우승자인지 확인(거짓)")
    void test_우승자_확인_False() {
        car.move(3);

        int winnerPosition = 1;

        assertThat(car.comparePosition(winnerPosition)).isFalse();
    }
}
