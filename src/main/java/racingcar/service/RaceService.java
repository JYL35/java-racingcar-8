package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public class RaceService {
    private final MoveStrategy moveStrategy;

    public RaceService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void startOneRound(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = moveStrategy.getNumber();
            car.move(randomNumber);
        }
    }
}
