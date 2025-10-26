package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRoster;
import racingcar.domain.RaceRounds;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceServiceTest {
    private RaceService raceService;
    private List<Car> carList;
    private RaceRounds raceRounds;

    @BeforeEach
    void 경주_준비() {
        String testInput = "even ,pobi, woni,30";
        CarRoster carRoster = new CarRoster(testInput);
        carList = carRoster.createCars();
        String testRound = "3";
        raceRounds = new RaceRounds(testRound);
    }

    @Test
    @DisplayName("고정된 값 4를 주어 경주를 n번 진행한다(이동함)")
    void test_경주_n번_테스트1() {
        MoveStrategy moveStrategy = () -> 4;
        raceService = new RaceService(moveStrategy);

        raceService.raceStart(carList, raceRounds);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).comparePosition(3)).isTrue();
        }
    }

    @Test
    @DisplayName("고정된 값 3를 주어 경주를 n번 진행한다(이동하지 않음)")
    void test_경주_n번_테스트2() {
        MoveStrategy moveStrategy = () -> 3;
        raceService = new RaceService(moveStrategy);

        raceService.raceStart(carList, raceRounds);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).comparePosition(0)).isTrue();
        }
    }
}