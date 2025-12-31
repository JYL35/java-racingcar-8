package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.service.domain.Car;
import racingcar.service.domain.CarName;

public class RaceService {
    private static final int RANDOM_STARTING_NUMBER = 0;
    private static final int RANDOM_ENDING_NUMBER = 9;

    private List<Car> carRoster;

    public void createCars(List<String> names) {
        carRoster = names.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
    }

    public void raceStart(int RoundNumber) {
        for (int i = 0; i < RoundNumber; i++) {
            oneRoundStart();
        }
    }

    private void oneRoundStart() {
        for (Car car : carRoster) {
            car.move(movementStrategy());
        }
    }

    private int movementStrategy() {
        return Randoms.pickNumberInRange(RANDOM_STARTING_NUMBER, RANDOM_ENDING_NUMBER);
    }
}
