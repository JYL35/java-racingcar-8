package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRoster;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceServiceTest {
    private RaceService raceService;
    private List<Car> carList;

    @BeforeEach
    void 경주_준비() {
        String testInput = "even ,pobi, woni,30";
        CarRoster carRoster = new CarRoster(testInput);
        carList = carRoster.createCars();
    }

    @Test
    @DisplayName("고정된 값 4를 주어 경주를 1번 진행한다(이동함)")
    void test_경주_n번_테스트1() {
        MoveStrategy moveStrategy = () -> 4;
        raceService = new RaceService(moveStrategy);

        raceService.startOneRound(carList);

        for (Car car : carList) {
            assertThat(car.comparePosition(1)).isTrue();
        }
    }

    @Test
    @DisplayName("고정된 값 3를 주어 경주를 1번 진행한다(이동하지 않음)")
    void test_경주_n번_테스트2() {
        MoveStrategy moveStrategy = () -> 3;
        raceService = new RaceService(moveStrategy);

        raceService.startOneRound(carList);

        for (Car car : carList) {
            assertThat(car.comparePosition(0)).isTrue();
        }
    }

    @Test
    @DisplayName("최종 우승자를 선별한다(단독 우승)")
    void test_단독_우승자_선별_테스트() {
        MoveStrategy moveStrategy = () -> 3;
        raceService = new RaceService(moveStrategy);

        carList.get(0).move(4);

        List<String> winners = raceService.findWinners(carList);

        assertThat(winners).contains("even");
        assertThat(winners).doesNotContain("pobi", "woni", "30");
    }

    @Test
    @DisplayName("최종 우승자를 선별한다(공동 우승)")
    void test_공동_우승자_선별_테스트() {
        MoveStrategy moveStrategy = () -> 3;
        raceService = new RaceService(moveStrategy);

        carList.get(0).move(4);
        carList.get(1).move(4);
        carList.get(2).move(4);

        List<String> winners = raceService.findWinners(carList);

        assertThat(winners).contains("even", "pobi", "woni");
        assertThat(winners).doesNotContain("30");
    }
}